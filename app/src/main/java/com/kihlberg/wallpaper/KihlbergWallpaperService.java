package com.kihlberg.wallpaper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

/**
 * Created by root on 3/13/15.
 */
public class KihlbergWallpaperService extends WallpaperService {

    private IWallpaperCanvasService canvasService;

    public KihlbergWallpaperService() {
        canvasService = AppInitializer.GetCanvasService();
    }

    @Override

    public Engine onCreateEngine(){
        return new KihlbergWallpaperEngine();
    }

    private class KihlbergWallpaperEngine  extends WallpaperService.Engine {

        private final Handler mHandler = new Handler();

        private final Runnable mUpdateDisplay = new Runnable() {
            @Override
            public void run() {
                draw();
            }
        };

        private boolean mVisible = false;

        @Override
        public void onVisibilityChanged(boolean visible) {
            mVisible = visible;
            if (visible) {
                draw();
            } else {
                mHandler.removeCallbacks(mUpdateDisplay);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            canvasService.UpdateCanvasSize(width,height);
            draw();
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            mVisible = false;
            mHandler.removeCallbacks(mUpdateDisplay);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mVisible = false;
            mHandler.removeCallbacks(mUpdateDisplay);
        }

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas c = canvasService.DrawCanvas(holder);
            if (c != null)
                holder.unlockCanvasAndPost(c);
            mHandler.removeCallbacks(mUpdateDisplay);

            if (mVisible) {
                mHandler.postDelayed(mUpdateDisplay, 10);
            }
        }
    }
}
