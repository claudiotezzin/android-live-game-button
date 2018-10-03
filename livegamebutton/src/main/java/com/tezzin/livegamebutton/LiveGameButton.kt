package com.tezzin.livegamebutton

import android.content.Context
import android.graphics.Canvas
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

class LiveGameButton : Button {

//    private var backgroundColor = -0x333334
//    private var shadowColor = -0x555556
//    private var corners = 4f
//    private var pressedHeight = 1.5f
//    private var normalHeight = 4f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        includeFontPadding = false
//
//        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LiveGameButton, defStyleAttr, 0)
//        if (typedArray != null) {
//            backgroundColor = typedArray.getColor(R.styleable.LiveGameButton_backgroundColor, backgroundColor)
//            shadowColor = typedArray.getColor(R.styleable.LiveGameButton_shadowColor, shadowColor)
//            corners = typedArray.getDimension(R.styleable.LiveGameButton_corners, dipToPixels(getContext(), corners))
//            pressedHeight = typedArray.getDimension(R.styleable.LiveGameButton_pressedHeight, dipToPixels(getContext(), pressedHeight))
//            normalHeight = typedArray.getDimension(R.styleable.LiveGameButton_normalHeight, dipToPixels(getContext(), normalHeight))
//            typedArray.recycle()
//        }
//
//        gravity = Gravity.CENTER
//        setOnClickListener(null)
//
//        initBackground()
    }

//    override fun onTouchEvent(event: MotionEvent): Boolean {
//        if (isEnabled) {
//            if (event.action == MotionEvent.ACTION_DOWN) {
//                isPressed = true
//            }
//        }
//        return super.onTouchEvent(event)
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        var additionalPadding: Float
//
//        if (isPressed) {
//            additionalPadding = (height + normalHeight) / 2
//            additionalPadding -= pressedHeight
//        } else {
//            additionalPadding = (height - normalHeight) / 2
//        }
//        additionalPadding -= (lineHeight / 2).toFloat()
//
//        val textPaint = paint
//        textPaint.color = currentTextColor
//        textPaint.drawableState = drawableState
//        canvas.save()
//        canvas.translate(0f, additionalPadding)
//        if (layout != null) {
//            layout.draw(canvas)
//        }
//        canvas.restore()
//    }
//
//    private fun initBackground() {
//        val states = StateListDrawable()
//        states.addState(intArrayOf(android.R.attr.state_pressed), getLayerList(true))
//        states.addState(intArrayOf(), getLayerList(false))
//
//        background = states
//    }
//
//    private fun getLayerList(isPressed: Boolean): LayerDrawable {
//
//        val radii = FloatArray(8)
//        for (i in radii.indices) {
//            radii[i] = corners
//        }
//
//        val shapeShadow = ShapeDrawable(RectShape())
//        shapeShadow.paint.color = shadowColor
//        shapeShadow.shape = RoundRectShape(radii, null, null)
//
//        val shapeBackground = ShapeDrawable(RectShape())
//        shapeBackground.paint.color = backgroundColor
//        shapeBackground.shape = RoundRectShape(radii, null, null)
//
//        val composite = LayerDrawable(arrayOf<Drawable>(shapeShadow, shapeBackground))
//
//        if (isPressed) {
//            composite.setLayerInset(0, 0, (normalHeight - pressedHeight).toInt(), 0, 0)
//            composite.setLayerInset(1, 0, (normalHeight - pressedHeight).toInt(), 0, pressedHeight.toInt())
//        } else {
//            composite.setLayerInset(0, 0, 0, 0, 0)
//            composite.setLayerInset(1, 0, 0, 0, normalHeight.toInt())
//        }
//
//        return composite
//    }
//
//    private fun dipToPixels(context: Context, dipValue: Float): Float {
//        val metrics = context.resources.displayMetrics
//        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
//    }
//
//    fun getBackgroundColor(): Int {
//        return backgroundColor
//    }
//
//    override fun setBackgroundColor(backgroundColor: Int) {
//        this.backgroundColor = backgroundColor
//        initBackground()
//    }
//
//    override fun getShadowColor(): Int {
//        return shadowColor
//    }
//
//    fun setShadowColor(shadowColor: Int) {
//        this.shadowColor = shadowColor
//        initBackground()
//    }
//
//    fun getCorners(): Float {
//        return corners
//    }
//
//    fun setCorners(corners: Float) {
//        this.corners = corners
//        initBackground()
//    }
//
//    fun getPressedHeight(): Float {
//        return pressedHeight
//    }
//
//    fun setPressedHeight(pressedHeight: Float) {
//        this.pressedHeight = pressedHeight
//        initBackground()
//    }
//
//    fun getNormalHeight(): Float {
//        return normalHeight
//    }
//
//    fun setNormalHeight(normalHeight: Float) {
//        this.normalHeight = normalHeight
//        initBackground()
//    }
}