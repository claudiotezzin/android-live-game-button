package com.tezzin.livegamebutton

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.StateListDrawable
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.widget.Button

class JereButton : Button {
    private val defaultBackgroundColor = Color.rgb(131, 158, 46)
    private val defaultShadowColor = Color.rgb(128, 128, 128)
    private val defaultCorners = 4f

    private var shadowHeightPressed = 1.5f
    private var shadowHeightNormal = 4f
    private var drawableBackground: Drawable? = null
    private var shadowDrawableBackground: Drawable? = null

    private var leftDrawable: Drawable? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.JereButton, defStyleAttr, 0)
        if (typedArray != null) {
            shadowHeightPressed = typedArray.getDimension(R.styleable.JereButton_shadowHeightPressed, dipToPixels(shadowHeightPressed))
            shadowHeightNormal = typedArray.getDimension(R.styleable.JereButton_shadowHeightNormal, dipToPixels(shadowHeightNormal))
            drawableBackground = typedArray.getDrawable(R.styleable.JereButton_drawableBackground)
            shadowDrawableBackground = typedArray.getDrawable(R.styleable.JereButton_shadowDrawableBackground)
            typedArray.recycle()
        }

        gravity = Gravity.CENTER
        setOnClickListener(null)

        initBackground()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (isEnabled) {
            if (event.action == MotionEvent.ACTION_DOWN) {
                isPressed = true
            }
        }
        return super.onTouchEvent(event)
    }

    override fun setCompoundDrawablesWithIntrinsicBounds(left: Drawable?,
                                                         top: Drawable?, right: Drawable?, bottom: Drawable?) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
        if (left == null) return
        leftDrawable = left
    }

    override fun onDraw(canvas: Canvas) {
        val leftDwb = leftDrawable

        val textDx = if (leftDwb != null)
            20 + leftDwb.intrinsicWidth / 2f
        else
            0f

        var additionalPadding: Float

        if (isPressed) {
            additionalPadding = (height + shadowHeightNormal) / 2
            additionalPadding -= shadowHeightPressed
        } else {
            additionalPadding = (height - shadowHeightNormal) / 2
        }
        additionalPadding -= (lineHeight / 2).toFloat()

        val textPaint = paint
        textPaint.color = currentTextColor
        textPaint.drawableState = drawableState
        canvas.save()
        canvas.translate(textDx, additionalPadding)
        layout?.draw(canvas)
        canvas.restore()

        if (leftDwb != null) {
            canvas.save()
            additionalPadding -= lineHeight
            val widthOfText = paint.measureText(text.toString()).toInt()
            val left = (width - widthOfText) / 2 - leftDwb.intrinsicWidth - 20
            canvas.translate(left.toFloat(), ((height - leftDwb.intrinsicHeight) / 2f) + additionalPadding)
            leftDrawable?.draw(canvas)
            leftDrawable?.draw(canvas)
            canvas.restore()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var height = measuredHeight
        val leftDwb = leftDrawable
        if (leftDwb != null) {
            height = Math.max(height, leftDwb.intrinsicHeight + paddingTop + paddingBottom)
            setMeasuredDimension(measuredWidth, height)
        }
    }

    private fun initBackground() {
        val states = StateListDrawable()
        states.addState(intArrayOf(android.R.attr.state_pressed), getLayerList(true))
        states.addState(intArrayOf(), getLayerList(false))
        background = states
    }

    private fun getLayerList(isPressed: Boolean): LayerDrawable {
        //init defaults
        val radii = FloatArray(8)
        for (i in radii.indices) {
            radii[i] = defaultCorners
        }

        val shapeShadow = ShapeDrawable(RectShape())
        shapeShadow.paint.color = defaultShadowColor
        shapeShadow.shape = RoundRectShape(radii, null, null)

        val shapeBackground = ShapeDrawable(RectShape())
        shapeBackground.paint.color = defaultBackgroundColor
        shapeBackground.shape = RoundRectShape(radii, null, null)

        //Init drawables
        val bkgDrawable = drawableBackground ?: shapeBackground
        val shadowDrawable = shadowDrawableBackground ?: shapeShadow

        val composite = LayerDrawable(arrayOf(shadowDrawable, bkgDrawable))

        if (isPressed) {
            composite.setLayerInset(0, 0, (shadowHeightNormal - shadowHeightPressed).toInt(), 0, 0)
            composite.setLayerInset(1, 0, (shadowHeightNormal - shadowHeightPressed).toInt(), 0, shadowHeightPressed.toInt())
        } else {
            composite.setLayerInset(0, 0, 0, 0, 0)
            composite.setLayerInset(1, 0, 0, 0, shadowHeightNormal.toInt())
        }

        return composite
    }

    private fun dipToPixels(dipValue: Float): Float {
        val metrics = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
    }
}