package stroll2;

public class Walker {

	private String name;//名前
	private int feeling;//気分
	private double careful;//危機管理能力
	private double fortune;//運

	Walker() {
		this.name = "散歩人";
	}

	//各種属性のsetter、getter
	String getName() {
		return this.name;
	}

	int getFeeling() {
		return this.feeling;
	}

	void setFeeling(int feeling) {
		this.feeling = feeling;
	}

	double getCareful() {
		return this.careful;
	}

	void setCareful(double careful) {
		this.careful = careful;
	}

	double getFortune() {
		return this.fortune;
	}

	void setFortune(int fortune) {
		this.fortune = fortune;
	}

	//散歩人気分が上がる
	void high(int num) {
		switch (num) {
		case 1 -> {
			this.feeling += 2;
		}
		case 2 -> {
			this.feeling += 3;
		}
		case 3 -> {
			this.feeling += 4;
		}
		}

	}

	//散歩人気分が下がる
	void low() {
		this.feeling -= 5;
	}

	String selectSeason() {

		int seasonSelect;
		do {
			System.out.println("散歩したい季節は？");
			System.out.println("1:春　2:夏　3:秋　4:冬");
			seasonSelect = new java.util.Scanner(System.in).nextInt();
		} while (seasonSelect < 1 || seasonSelect > 4);

		String season = null;
		switch (seasonSelect) {
		case 1 -> {
			season = "春";
		}
		case 2 -> {
			season = "夏";
		}
		case 3 -> {
			season = "秋";
		}
		default -> {
			season = "冬";
		}

		}
		return season;
	}

	//散歩の距離を決める
	int selectDistance() {
		int distance;
		do {
			System.out.println("今日はどれくらい散歩する？");
			System.out.println("1:短　2:中　3:長");
			distance = new java.util.Scanner(System.in).nextInt();
		} while (distance < 1 || distance > 3);
		System.out.println("\n");

		return distance;
	}

	//今日の運勢
	void fortuneTelling() {

		System.out.print("今日の運勢：");
		int fortune = new java.util.Random().nextInt(3);

		switch (fortune) {
		case 0 -> {
			System.out.println("大吉");
			this.setFortune(2);
		}
		case 1 -> {
			System.out.println("中吉");
			this.setFortune(4);
		}
		case 2 -> {
			System.out.println("末吉");
			this.setFortune(6);
		}
		default -> {
			System.out.println("凶");
			this.setFortune(8);
		}
		}
		System.out.print("\n");
	}

	//散歩する
	void walk(Event event, Judge judge, String season) {
		Data a;

		System.out.print("〇");

		//良イベント
		if (event instanceof GoodEvent good) {
			a = good.eventSelect(this, season);
			good.eventHappen(a, this, judge);

			//悪イベント
		} else if (event instanceof BadEvent bad) {
			a = bad.eventSelect(this, season);
			bad.eventHappen(a, this, judge);
		}

	}

	//散歩人の気分チェック
	boolean sanCheck() {

		boolean home = false;
		//気分が0以下だとゲームオーバー判定のhomeをtrueにする
		if (this.feeling <= 0) {
			home = true;
			System.out.println("気分が下がって家に帰りたくなった...");
		}
		return home;
	}

	//クイズの回答をする
	int answer() {
		int answer = 0;
		do {
			System.out.print("回答：");
			answer = new java.util.Scanner(System.in).nextInt();

		} while (answer < -1 || answer > 15);
		return answer;
	}

	//ゲームオーバー
	void gameOver() {
		System.out.print("\n");
		System.out.println("　　　　　　　ーーーGAME OVERーーー");

		System.out.println("１：リトライ　２：ゲーム終了");
		int continued = 0;
		do {
			continued = new java.util.Scanner(System.in).nextInt();
		} while (continued < 1 || continued > 2);

		//リトライの場合はもう一度メインメソッド呼び出し
		if (continued == 1) {
			Main.main(null);
		}

	}

	//ゲームクリア
	void gameClear() {
		
			System.out.println("念願の散歩名人になった！！");
			System.out.print("\n");
			System.out.println("　　　　　　　ーーーGAME CLEARーーー");
			System.out.println("\n");
		

	}

}
