package stroll2;

import java.util.ArrayList;
import java.util.List;

public class GoodEvent extends Event {

	List<Data> list = new ArrayList<>();

	//発生イベント選択
	Data eventSelect(Walker w, String season) {

		list.add(new Data("空がめちゃ綺麗だった", "A"));
		list.add(new Data("綺麗な花を見かけた", "C"));
		list.add(new Data("四葉のクローバーを発見", "B"));
		list.add(new Data("微笑ましい親子とすれ違った", "C"));
		list.add(new Data("なんとなくいい気分な気がする", "C"));
		list.add(new Data("信号に全然捕まらない", "C"));

		//季節特有イベント追加
		switch (season) {
		case "春" -> {
			list.add(new Data("満開の桜を静かに見れる場所を見つけた", "A"));
			list.add(new Data("春特有のあたたかい空気を感じた", "B"));
		}
		case "夏" -> {
			list.add(new Data("夏っぽい雲を見た", "A"));
			list.add(new Data("風鈴の音が聴こえた","A"));
		}
		case "秋" -> {
			list.add(new Data("面白い形のどんぐりが落ちていた", "B"));
			list.add(new Data("紅葉が綺麗で秋を感じた", "A"));
			list.add(new Data("りすが目の前を横切った","B"));
		}
		default -> {
			list.add(new Data("まだ誰も歩いていない真っ白な道を歩ける", "A"));
			list.add(new Data("めちゃいい音がする氷を踏んだ", "A"));
		}
		}

		//良いイベントの中からランダムで
		int select = new java.util.Random().nextInt(list.size());
		//乱数でリストに入っているイベント内容を表示
		Data data = list.get(select);
		System.out.println(data.getText());

		return data;
	}

	//イベント影響
	void eventHappen(Data data, Walker w, Judge judge) {
		//マップの値によって気分値の上がり方を変える
		switch (data.getAbc()) {
		case "A" -> {
			//４上がる
			w.high(3);
		}
		case "B" -> {
			//３上がる
			w.high(2);
		}
		default -> {
			//２上がる
			w.high(1);
		}

		}
		//良イベントが起きた回数を数える
		System.out.println("\n");
		judge.setGoodNum(judge.getGoodNum() + 1);
	}

}
