package stroll2;

public abstract class Event {

	abstract Data eventSelect(Walker w, String season);

	abstract void eventHappen(Data a, Walker w, Judge judge);
}
