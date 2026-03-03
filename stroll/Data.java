package stroll2;

//それぞれイベントのテキスト内容と回復量の
public class Data {

	private String text;
	private String abc;

	public String getText() {
		return text;
	}

	public String getAbc() {
		return abc;
	}

	//良イベントの時はイベントテキストと回復量決めるabcが必要
	Data(String text, String abc) {
		this.text = text;
		this.abc = abc;
	}

	//悪イベントはイベントテキストだけ必要
	Data(String text) {
		this.text = text;
	}

}
