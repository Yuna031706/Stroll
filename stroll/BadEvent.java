package stroll2;

import java.util.ArrayList;
import java.util.List;

public class BadEvent extends Event {

	List<Data> list = new ArrayList<>();

	//発生イベント選択
	Data eventSelect(Walker w, String season) {

		//悪いイベント内容追加
		list.add(new Data("犬に吠えられた"));
		list.add(new Data("頭上にカラスがいた"));
		list.add(new Data("３回連続で赤信号に捕まった"));
		list.add(new Data("ポイ捨てされているゴミを見つけた"));
		list.add(new Data("靴ひもがほどけた"));

		switch (season) {
		case "春" -> {
			list.add(new Data("模様がえぐい毛虫がいた"));

		}
		case "夏" -> {
			list.add(new Data("外が暑すぎて暑すぎて暑い"));
			list.add(new Data("ちょいでかめの虫が顔面にぶち当たってきそう"));

		}
		case "秋" -> {
			list.add(new Data("雪虫が大量発生してた"));

		}
		default -> {
			list.add(new Data("道が凍ってて滑って転んだ"));
			list.add(new Data("歩道に雪がめちゃ積もってた"));

		}
		}

		//悪いイベントの中からランダムで
		int select = new java.util.Random().nextInt(list.size());
		//乱数でリストに入っているイベント内容を表示
		Data data = list.get(select);
		System.out.println(data.getText());

		//危機管理を0.25プラス
		w.setCareful(w.getCareful() + 0.25);

		return data;
	}

	//イベント影響
	void eventHappen(Data data, Walker w, Judge judge) {

		System.out.println("**行動選択**");

		switch (data.getText()) {
		//↓全季節イベント
		case "犬に吠えられた" -> {
			System.out.println("１：犬にびびり散らかしながら通り過ぎる");
			System.out.println("２：めちゃ作り笑いで対応する");
			System.out.println("３：自分から犬との交流を図りに行く");

			//doSelect(答えの番号,散歩人,判定人)
			doSelect(1, w, judge);
		}
		case "頭上にカラスがいた" -> {
			System.out.println("１：頭上をめっちゃ気にしながら通り過ぎる");
			System.out.println("２：凄まじい殺意を持って石を投げる");
			System.out.println("３：カラスに挨拶する");

			doSelect(3, w, judge);

			judge.setCrowNum(judge.getCrowNum() + 1);

		}
		case "３回連続で赤信号に捕まった" -> {
			System.out.println("１：周りの景色を見てのんびり待つ");
			System.out.println("２：堂々と信号無視をする");
			System.out.println("３：人間観察をして暇をつぶす");

			doSelect(3, w, judge);
		}
		case "ポイ捨てされているゴミを見つけた" -> {
			System.out.println("１：助走をつけて蹴り飛ばす");
			System.out.println("２：手に厳重な装備をして拾う");
			System.out.println("３：見なかったことにする");

			doSelect(2, w, judge);
		}
		case "靴ひもがほどけた" -> {
			System.out.println("１：歩道の端っこに寄って靴ひもを結ぶ");
			System.out.println("２：ちょっとめんどくさいからそのまま歩く");
			System.out.println("３：靴ひもぶん回し歩きをして楽しむ");

			doSelect(1, w, judge);
		}
		//↑全季節イベント

		//春イベント
		case "模様がえぐい毛虫がいた" -> {
			System.out.println("１：きょどりながら挨拶する");
			System.out.println("２：全力で目をそらす");
			System.out.println("３：感じた不快さを全面に声に出す");

			doSelect(1, w, judge);
		}

		//夏イベント
		case "外が暑すぎて暑すぎて暑い" -> {
			System.out.println("１：開き直って光合成する");
			System.out.println("２：日陰しか通れないよゲームをする");
			System.out.println("３：日傘をさして対処する");

			doSelect(2, w, judge);
		}
		case "ちょいでかめの虫が顔面にぶち当たってきそう" -> {
			System.out.println("１：類まれな反射力で避ける");
			System.out.println("２：当たらないことを祈って目をつぶる");
			System.out.println("３：くそでかい声を出して威嚇する");

			doSelect(1, w, judge);
		}

		//秋イベント
		case "雪虫が大量発生してた" -> {
			System.out.println("１：マスクと眼鏡を装着する");
			System.out.println("２：全てを受け入れて歩く");
			System.out.println("３：避けながら歩くことに全力を注ぐ");

			doSelect(2, w, judge);
		}

		//冬イベント
		case "道が凍ってて滑って転んだ" -> {
			System.out.println("１：凍っている道と大喧嘩する");
			System.out.println("２：何事もなかったかのように立ち上がる");
			System.out.println("３：見ていた人がいないか周りを見まわしまくる");

			doSelect(2, w, judge);

		}
		case "歩道に雪がめちゃ積もってた" -> {
			System.out.println("１：進むのを諦めて違う道を探しに行く");
			System.out.println("２：雪の上に乗れるか一歩だけ試しに踏み出す");
			System.out.println("３：躊躇せずにそのまま雪の中を突き進む");

			doSelect(3, w, judge);
		}

		}

		System.out.println("\n");
		judge.setBadNum(judge.getBadNum() + 1);

	}

	//行動選択の入力
	void doSelect(int num, Walker w, Judge judge) {
		int doing;
		do {
			doing = new java.util.Scanner(System.in).nextInt();
		} while (doing < 1 || doing > 3);

		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (num) {
		case 1 -> {
			//１が正解
			if (doing == num) {
				success(judge);
			} else {
				fail(w, judge);
			}
		}
		case 2 -> {
			//２が正解
			if (doing == num) {
				success(judge);
			} else {
				fail(w, judge);
			}
		}
		default -> {
			//３が正解
			if (doing == num) {
				success(judge);
			} else {
				fail(w, judge);
			}
		}
		}

	}

	void success(Judge judge) {
		System.out.print("\n");
		System.out.println("行動選択成功！！");
		//行動成功カウント+1
		judge.setSuccessNum(judge.getSuccessNum() + 1);

	}

	void fail(Walker w, Judge judge) {
		System.out.print("\n");
		System.out.println("行動選択失敗...");
		//散歩人のテンションが-5
		w.low();
		//行動失敗カウント+1
		judge.setFailNum(judge.getFailNum() + 1);
	}

}
