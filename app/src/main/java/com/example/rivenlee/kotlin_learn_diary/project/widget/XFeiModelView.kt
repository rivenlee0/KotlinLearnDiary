package com.example.rivenlee.kotlin_learn_diary.project.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.View
import com.example.rivenlee.kotlin_learn_diary.R

/**
 * FileName: XfeiModelView
 * Author: rivenLee
 * Date: 2020/10/21 9:52
 */

class XFeiModelView(context: Context?, attrs: AttributeSet?): View(context, attrs) {

    private lateinit var paint: Paint
    private lateinit var dstBitmap: Bitmap
    private lateinit var srcBitmap: Bitmap
    private lateinit var canvas: Canvas
    private lateinit var path: Path
    private lateinit var porterDuffXfermode: PorterDuffXfermode

    init {
        initPaint()
    }

    private fun initPaint() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
        paint.alpha = 0
        paint.strokeWidth = 50f
        paint.style = Paint.Style.STROKE
        dstBitmap = decodeBitmapFormRes(R.drawable.img_girl, width, 900)
        srcBitmap = Bitmap.createBitmap(dstBitmap.width, dstBitmap.height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(srcBitmap)
        canvas.drawColor(Color.GRAY)
        path = Path()
        porterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(dstBitmap, 0f, 0f, null)
        drawPath()
        canvas?.drawBitmap(srcBitmap, 0f, 0f, null)
    }

    private fun drawPath() {
        paint.xfermode = porterDuffXfermode
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.reset()
                path.moveTo(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(event.x, event.y)
            }
            else -> {
            }
        }
        postInvalidate()
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val wSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val wSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        val hSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val hSpecSize = MeasureSpec.getSize(heightMeasureSpec)
        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(900, 900)
        } else if (wSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(900, hSpecSize)
        } else if (hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize, 900)
        }
    }

    private fun decodeBitmapFormRes(resId: Int, targetWidth: Int, targetHeight: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565
        options.inJustDecodeBounds = false
        BitmapFactory.decodeResource(resources, resId, options)
        val inSample = calculateInSample(options, targetWidth, targetHeight)
        options.inSampleSize = inSample
        return BitmapFactory.decodeResource(resources, resId, options)
    }

    private fun calculateInSample(options: BitmapFactory.Options, targetWidth: Int, targetHeight: Int): Int {
        if (targetWidth <= 0 || targetHeight <= 0) return 1
        var inSample = 1
        val rawWidth = options.outWidth
        val rawHeight = options.outHeight
        if (rawWidth > targetWidth || rawHeight > targetHeight) {
            val halfWidth = rawWidth / 2
            val halfHeight = rawHeight / 2
            while ((halfWidth / inSample >= targetWidth) && (halfHeight / inSample) >= targetHeight) {
                inSample *= 2
            }
        }
        return inSample
    }
}
