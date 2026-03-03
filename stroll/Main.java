package stroll2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Enterを押してゲームスタート！");
		new Scanner(System.in).nextLine();

		System.out.println("　　　　　　　ーーーさんぽ道ーーー");
		System.out.println("5日間の散歩をこなして散歩名人を目指そう！");
		System.out.println("悪いイベントを通過するには正しい行動選択が必要。");
		System.out.println("気分が下がって家に帰りたくなると、ゲームオーバー。");
		System.out.println("散歩名人目指して頑張ろう！！");
		System.out.println("\n");

		Weather weather = new Weather();
		Walker w = new Walker();
		GoodEvent good = new GoodEvent();
		BadEvent bad = new BadEvent();
		Judge judge = new Judge();

		boolean home = false;

		//季節選ぶ
		String season = w.selectSeason();

		//５日間のループ
		for (int i = 0; i < 5; i++) {
			if (home == true) {
				break;
			}

			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//日数の表示
			System.out.println("　　<" + (i + 1) + "日目>");

			//今日の天気を決めて散歩人の気分の初期値を決定
			weather.todayWeather(w, season);
			//今日の運勢
			w.fortuneTelling();

			//距離を決定　1:短　2:中　3:長
			int distance = w.selectDistance();

			//一日の距離分イベントを起こす
			for (int j = 0; j < distance; j++) {
				if (home == true) {
					break;
				}

				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//良いことが起きるか悪いことが起きるかの分岐
				int happen = new java.util.Random().nextInt(11);
				//基準値
				double bunki = w.getFortune() - w.getCareful();

				//危機管理能力が上がりすぎた時に0に設定する
				if (bunki < 0) {
					bunki = 0;
				}
				//基準(bunki)より小さかったら悪イベント
				if (happen <= bunki) {

					w.walk(bad, judge, season);

					//大きかったら良イベント
				} else {

					w.walk(good, judge, season);
				}

				//帰りたくなってないか確認
				home = w.sanCheck();
				if (home) {
					w.gameOver();
				}
			}

		}

		try {
			//散歩を切り抜けた先のクイズ
			judge.quiz(home, w);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
