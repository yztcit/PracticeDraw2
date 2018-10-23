package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11StrokeMiterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice11StrokeMiterView(Context context) {
        super(context);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);

        path.rLineTo(200, 0);
        path.rLineTo(-160, 120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //如果拐角的大小为 θ ，那么这个比值miter就等于 1 / sin ( θ / 2 )
        //这个 miter limit 的默认值是 4，对应的是一个大约 29° 的锐角
        //默认情况下，大于这个角的尖角会被保留，而小于这个夹角的就会被「削成平头」
        canvas.save();

        canvas.translate(100, 100);
        // MITER 值：1
        paint.setStrokeMiter(1);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        // MITER 值：2
        paint.setStrokeMiter(2);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        // MITER 值：5
        paint.setStrokeMiter(5);
        canvas.drawPath(path, paint);

        canvas.restore();
    }
}
