package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.example.rivenlee.kotlin_learn_diary.R
import kotlin.math.abs

/**
 * FileName: LevelProgressView
 * Author: rivenLee
 * Date: 2020/12/10 13:46
 */

class LevelProgressView(context: Context, attrs: AttributeSet?) : View(context, attrs, 0) {

    private var borderColor: Int = 0
    private var bgColor: Int = 0
    private var cursorColor: Int = 0
    private var currentProgress: Float = 0f
    private val borderSize = dp2px(10).toFloat()
    private val mStartAngle = 180f // 起始角度
    private val mSweepAngle = 180f // 绘制角度

    private val mPaint: Paint
    private val progressRect: RectF
    private lateinit var shader: LinearGradient

    init {
        initTypeArray(context, attrs)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        progressRect = RectF()
    }

    private fun initTypeArray(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LevelProgressView)
        borderColor = typedArray.getColor(R.styleable.LevelProgressView_lh_borderColor, Color.parseColor("#ff9a40"))
        bgColor = typedArray.getColor(R.styleable.LevelProgressView_lh_bgColor, Color.parseColor("#f6f6f6"))
        cursorColor = typedArray.getColor(R.styleable.LevelProgressView_lh_cursorColor, Color.YELLOW)
        currentProgress = typedArray.getFloat(R.styleable.LevelProgressView_lh_progress, 25f)
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?: return
        canvas.drawColor(Color.YELLOW)
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = borderSize
        mPaint.color = bgColor
        canvas.drawArc(progressRect, mStartAngle, mSweepAngle, false, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = borderSize
        mPaint.shader = shader
        canvas.drawArc(progressRect, mStartAngle, currentProgress, false, mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
        progressRect.set(borderSize /2f, borderSize /2f,
                abs(measuredWidth.toFloat() - borderSize/2f), abs(measuredWidth.toFloat() - borderSize * 2))
        shader =  LinearGradient(progressRect.left,progressRect.top,progressRect.right,progressRect.bottom/2f, Color.GREEN, Color.BLUE, Shader.TileMode.CLAMP)
    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                Resources.getSystem().displayMetrics).toInt()
    }

}