package com.x3n;

import java.awt.Button;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class practicas implements ApplicationListener {
	
		public OrthographicCamera cam;//Creamos la camara en vista ortogonal
		public Texture imagen;//La imagen que vamos a cargar
		//public TextureRegion tr;// solo mostrara una parte de nuestra imagen
		public SpriteBatch sb;//Carga todas las imagenes de nustro proyecto
					
		TextInputListener listener = new TextInputListener() {
			
			@Override
			public void input(String text) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void canceled() {
				// TODO Auto-generated method stub
				
			}
		};
		
	
	@Override
	public void create() { //Se ejecuta automaticamente cuando el juego empiece		
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		//int i = Gdx.graphics.getHeight();
		//int j = Gdx.graphics.get
		cam =new OrthographicCamera(w,h);
		imagen=new Texture(Gdx.files.internal("phanton.png"));
		sb=new SpriteBatch();//se le puede dar parametros como el numero de elementos que se quiere mostrar
		
		
		
	}

	@Override
	public void dispose() {//se ejecuta cuando se termina el juego, libera la memoria
		sb.dispose();
		imagen.dispose();
	}

	@Override
	public void render() {//Se ejecuta lo que se va a dibujar en el juego, tbn la logica de nustro juego
		//Las siguiente dos linas de codigo limpian la pantalla y establecen un color de fondo
			Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);//This cryptic line clears the screen.
			
			int h = Gdx.graphics.getHeight(); //almacenamos el alto de la pantalla
			int w = Gdx.graphics.getWidth();
			int i = Gdx.input.getX(0);//Almacenamos la pocicion del puntero x (primer indice)
			int j = Gdx.input.getY(0);//Almacenamos la pocicion del puntero y
			int u= Gdx.input.getX(1);//Almacena la pocicion del puntero x (segundo indice)
			int t= Gdx.input.getY(1);
			int l =(imagen.getWidth()/2); 
			int p =(imagen.getHeight()/2);
			
			practicas mc= new practicas();
			
		sb.begin();
		
		
		
		
		//sb.draw(imagen,15,15);//cargamos la textura en pantalla
				
		if(Gdx.input.isTouched(0)){
			sb.draw(imagen,i-l,(h-j)-p);
			/*Para dibujar la textura libGdx toma como punto de origen la parte superior Izquierda, mientras que para tomar la ubicacion del mouse 
			 * el punto de origen es la parte inferior Izquierda, al momento de mover el mouse en el eje Y veremos que se muestra de manera opuesta a 
			 * la direccion que indicamos, para solucionar esto hacemos lo siguiente: tomamos el ancho de la pantalla y lo restamos con la ubicacione en Y
			 * de el mouse de esta manera la imagen seguira la direccion de nuestro mouse en el eje Y (en el eje X el comportamiento es normal)
			 * Para hacer que el mouse se ubique en el centro de la Imagen al momento de hacer click solo tenemos que restar la mitad de el ancho y de el alto 
			 * de nustra imagen al momento de dibujarlo*/
			
			//Dibujamos la textura en diferentes lugares.
			sb.draw(imagen,i-l,j-p);
			sb.draw(imagen,(w-i)-l,j-p);
			sb.draw(imagen, (w-i)-l,(h-j)-p);
		}
		
		if(Gdx.input.isTouched(1)){//Seundo touch usa las coordenadas del indice 1
			sb.draw(imagen,u-l,(h-t)-p);
			sb.draw(imagen,u-l,t-p);
			sb.draw(imagen,(w-u)-l,t-p);
			sb.draw(imagen, (w-u)-l,(h-t)-p);
		}
		
		/*if(Gdx.input.justTouched()){
		Gdx.input.setCursorPosition(w/2,h/2);
		}*/
		/*if(Gdx.input.isTouched()){
			System.out.println("se toco X:" +i+ " Y: " + j);
		}*/
		
		if(Gdx.input.isKeyPressed(Keys.A)){//Deacuerdo a la flecha precionada dibuja la imagen
			//Gdx.input.setOnscreenKeyboardVisible(true);//Solo disponible en android
			sb.draw(imagen, 100, 100);
		}
		if(Gdx.input.isButtonPressed(Buttons.LEFT)){//Right, Middle, left los botones del mouse, en android solo funciona left
			sb.draw(imagen, 150, 150);
		}
		
		//Mostrar un cuadro para entrada de texto.
		if(Gdx.input.isKeyPressed(Keys.B)){
			Gdx.input.getTextInput(listener, "ola k ace?","");
			
		}
			sb.end();
		}

	@Override
	public void resize(int width, int height) {//Se ejecuta cuando se cambia el tamaño de nuestro juego
	}

	@Override
	public void pause() {// aqui va todo lo que no queremos que se pierda de nuestro juego
	}

	@Override
	public void resume() {// carga todo lo guardado anteriormente en pause
	}
}
