package Model;

public enum Department {

    TSE("纺织科学与工程学院"),
    ECE("环境与化学工程学院"),
    MAN("管理学院"),
    HSS("人文社会科学学院"),
    CS("计算机科学学院"),
    Marxism("马克思主义学院"),
    ME("材料工程学院"),
    MEE("机电工程学院"),
    EI("电子信息学院"),
    AAD("服装与艺术设计学院"),
    SS("理学院"),
    NMA("新媒体艺术学院"),
    AT("应用技术学院"),
    UPME("城市规划与市政工程学院");

    private String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
