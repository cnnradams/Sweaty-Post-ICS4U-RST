package gui.objects.colliders;

import backend.player.Player;
import gui.Display;
import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.VectorCreator;
import gui.objects.Rectangle;
import gui.scenes.Scene;
import main.Main;

public class SceneChangeCollider extends InteractableCollider {
	private Scene scene;
	private Vector2 position;
	private Player.Movement direction;
	public SceneChangeCollider(int length, int width, Vector2 position, Scene scene) {
		super(length, width, position);
		this.scene = scene;
	}
	public SceneChangeCollider(Rectangle rectangle, Scene scene) {
		super(rectangle);
		this.scene = scene;
	}
	public SceneChangeCollider(Rectangle rectangle, Scene scene, Vector2 position, Player.Movement direction) {
		super(rectangle);
		this.scene = scene;
		this.position = new Vector2(position.x, position.y);
		this.direction = direction;
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		scene.initialize();
		if(position != null) {
			Main.game.player.setPosition(VectorCreator.dimensionalVector2(position.x, position.y));
			Main.game.player.facingDir = this.direction;
			Main.game.currentOrientation = this.direction;
		}
	}

}
