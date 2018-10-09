package application.model;

import java.util.ArrayList;

import javafx.scene.shape.Circle;

public class Player {
	private int maxHealth;
	private int health;
	private int money;
	private double moveSpeed;
	private int lives;
	private int level;
	private int currXp;
	private int xpToLevel;
	private ArrayList<Item> items;
	private Circle playerCircle;
	private double velX, velY;
	
	public Player(int maxHealth, int lives, int level){
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.lives = lives;
		this.level = level;
		this.items = new ArrayList<Item>();
	}
	
	public void tick() {
	    playerCircle.setCenterX(playerCircle.getCenterX() + velX);
	    playerCircle.setCenterY(playerCircle.getCenterY() + velY);
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCurrXp() {
		return currXp;
	}

	public void setCurrXp(int currXp) {
		this.currXp = currXp;
	}

	public int getXpToLevel() {
		return xpToLevel;
	}

	public void setXpToLevel(int xpToLevel) {
		this.xpToLevel = xpToLevel;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}



	public Circle getPlayerCircle() {
		return playerCircle;
	}



	public void setPlayerCircle(Circle playerCircle) {
		this.playerCircle = playerCircle;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
}
