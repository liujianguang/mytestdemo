package com;

import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Testaaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "[{\"id\":4,\"name\":\"前台\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":5,\"name\":\"会议室\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":6,\"name\":\"实验室\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":7,\"name\":\"仓库\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":8,\"name\":\"爱维特办公区\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":9,\"name\":\"同望办公区\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1},{\"id\":10,\"name\":\"公共办公区\",\"url\":\"\",\"pid\":2,\"layer\":10000,\"drag\":false,\"isParent\":true,\"target\":\"right\",\"iconSkin\":\"pIcon01\",\"nodeepth\":1}]";
		Type type = new TypeToken<LinkedList<Nodes>>() {
		}.getType();
		Gson g = new Gson();
		LinkedList<Nodes> ll = g.fromJson(result, type);
		for (int i = 0; i < ll.size(); i++) {
		Nodes h = (Nodes) ll.get(i);
		System.out.println(h.getName() + "," + h.getDrag() + ","
		+ h.getIconSkin() + "," + h.getId() + "," + h.getIsParent()
		+ "," + h.getLayer() + "," + h.getNodeepth() + ","
		+ h.getId() + "," + h.getTarget() + "," + h.getId());

		}
	}

}
