package com.videogame.invasion.model;

public class Model {
	
	private LoadGame load;
	private SaveGame save;
	private SaveHighScore saveHighScore;
	private LoadHighScore loadHighScore;
	private Credits credits;
	
	public Model() {
	}

	public LoadGame getLoad() {
		return load;
	}

	public void setLoad(LoadGame load) {
		this.load = load;
	}

	public SaveGame getSave() {
		return save;
	}

	public void setSave(SaveGame save) {
		this.save = save;
	}

	public SaveHighScore getSaveHighScore() {
		return saveHighScore;
	}

	public void setSaveHighScore(SaveHighScore saveHighScore) {
		this.saveHighScore = saveHighScore;
	}

	public LoadHighScore getLoadHighScore() {
		return loadHighScore;
	}

	public void setLoadHighScore(LoadHighScore loadHighScore) {
		this.loadHighScore = loadHighScore;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}
}
