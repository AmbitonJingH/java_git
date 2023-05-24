public class SeasonTest {
    public static void main(String[] args) {

    }

}
//jdk5.0之前的枚举类实现方式
class Season{
    private final String seasonName;
    private final String Desc;//季节的描述
    //私有化类的构造器
    private Season(String seasonName,String Desc){
        this.seasonName=seasonName;
        this.Desc = Desc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getDesc() {
        return Desc;
    }
    //创建当前类的实例
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
