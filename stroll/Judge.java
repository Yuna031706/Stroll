package stroll2;

import java.util.HashMap;
import java.util.Map;

public class Judge {

	Map<Integer, String> question = new HashMap<>();

	//初期値は全て0
	private int goodNum = 0;
	private int badNum = 0;
	private int successNum = 0;
	private int failNum = 0;
	private int crowNum = 0;

	int getGoodNum() {
		return this.goodNum;
	}

	void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	int getBadNum() {
		return this.badNum;
	}

	void setBadNum(int badNum) {
		this.badNum = badNum;
	}

	int getSuccessNum() {
		return this.successNum;
	}

	void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}

	int getFailNum() {
		return this.failNum;
	}

	void setFailNum(int failNum) {
		this.failNum = failNum;
	}

	int getCrowNum() {
		return this.crowNum;
	}

	void setCrowNum(int crowNum) {
		this.crowNum = crowNum;
	}

	void quiz(boolean home, Walker w) throws InterruptedException {
		question.put(1, "良いイベントが起きた数は？");
		question.put(2, "悪いイベントが起きた数は？");
		question.put(3, "行動成功の数は？");
		question.put(4, "行動失敗の数は？");
		question.put(5, "カラスと出会った数は？");

		//クイズを間違えたときにゲームオーバーするためのフラグ
		boolean miss = false;
		//回答を格納する変数
		int answer = 0;
		
		//Q_A[0]にクイズの識別番号　[1]に出題するクイズ内容
		int[] Q_A = new int[2];

		//ゲームオーバー後にクイズをスルーできるように
		//homeがtrueになっているから何もしないで終了できる
		if (home) {

		} else {

			System.out.println("5日連続で散歩することに成功！");
			Thread.sleep(1000);
			System.out.println("これから出題されるクイズに全問正解すると、");
			Thread.sleep(1000);
			System.out.println("散歩名人になれるよ！");
			System.out.print("\n");

			for (int i = 0; i < 3; i++) {
				if (miss) {
					break;
				}
				int quiz = new java.util.Random().nextInt(question.size()) + 1;
				Thread.sleep(1500);
				System.out.println((i + 1) + "問目！");
				System.out.println(question.get(quiz));
				Q_A[0] = quiz;

				//散歩人にクイズの回答を求める
				answer = w.answer();
				Q_A[1] = answer;

				int num = quiz_TF(Q_A);
				miss = TF_msg(num, w, miss);

				if (i == 2) {
					w.gameClear();
				}
			}

		}

	}

	int quiz_TF(int[] Q_A) {
		int num = 0;
		switch (Q_A[0]) {
		case 1 -> {
			if (Q_A[1] == this.goodNum) {
				//正解だったら戻り値のnumに１代入
				num = 1;
			} else {
				//不正解は何もしない
			}
		}
		case 2 -> {
			if (Q_A[1] == this.badNum) {
				num = 1;
			} else {

			}
		}
		case 3 -> {
			if (Q_A[1] == this.successNum) {
				num = 1;
			} else {

			}
		}
		case 4 -> {
			if (Q_A[1] == this.failNum) {
				num = 1;
			} else {

			}
		}
		case 5 -> {
			if (Q_A[1] == this.crowNum) {
				num = 1;
			} else {

			}
		}

		}
		return num;
	}

	boolean TF_msg(int num, Walker w, boolean miss) throws InterruptedException {
		Thread.sleep(1500);
		if (num == 1) {
			System.out.println("正解！！");
			System.out.println("\n");
		} else {
			System.out.println("残念不正解！！");
			System.out.println("\n");
			miss = true;
			w.gameOver();
		}
		return miss;
	}

}
