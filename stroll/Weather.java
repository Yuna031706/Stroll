package stroll2;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	void todayWeather(Walker w, String season) {

		List<String> list = new ArrayList<>();
		list.add("晴れ");
		list.add("曇り");
		list.add("風");
		list.add("雨");

		if (season.equals("冬")) {
			list.add("雪");
		}

		int weather = new java.util.Random().nextInt(list.size());

		System.out.println("今日の天気：" + list.get(weather));

		switch (weather) {
		case 0 -> {
			//晴れ
			System.out.println("散歩日和すぎてテンション激高");
			w.setFeeling(10);
		}
		case 1 -> {
			//曇り
			System.out.println("正直晴れより散歩しやすいから嬉しさ爆発");
			w.setFeeling(8);
		}
		case 2 -> {
			//風
			System.out.println("風が強い日に散歩するのはなんとも微妙");
			w.setFeeling(5);
		}
		case 3, 4 -> {

			int rainSnow = 0;

			//雨か雪
			System.out.println("あなたは" + list.get(weather) + "でテンションが上がるタイプ？");
			System.out.println("１：はい　２：いいえ");
			do {
				rainSnow = new java.util.Scanner(System.in).nextInt();
			} while (rainSnow < 1 || rainSnow > 2);

			if (rainSnow == 1) {
				System.out.println("そんな" + list.get(weather) + "好きの人には良いことが起きてるよ！");
				w.setFeeling(8);
			} else {
				w.setFeeling(4);
				System.out.println("気乗りしないけどしゃーなし散歩");
			}

		}

		}
		System.out.print("\n");
	}
}
