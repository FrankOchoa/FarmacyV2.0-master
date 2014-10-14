package OpenGl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;


public class Render implements Renderer {

	private float rotationVar;

	private Context ctx;
	public Render(Context ctx){
		rotationVar  = 0;
		this.ctx = ctx;
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		gl.glDisable(GL10.GL_DITHER);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glClearColor(0f, 0f, 1f, 1f);
		gl.glClearDepthf(1f);

	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glDisable(GL10.GL_DITHER);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 20, -30, 0, 30, 0, 0, 1, 0);

		gl.glPushMatrix();
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glPopMatrix();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		//		sky = new Skydome(ctx.getResources().openRawResource(R.drawable.skb6), gl,100,100,50,0.5f,1);
		//		Terreno = new Terrain(ctx.getResources().openRawResource(R.drawable.pasto),ctx.getResources().openRawResource(R.drawable.heightmap), gl);
		gl.glViewport(0, 0, width, height);
		float ratio = (float)width/height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 100);
	}
}


