package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "testmapping")
public class TestMapping {
	private String name;
	private Integer idTest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

}
