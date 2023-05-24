public enum SeasonTest1 {

}
enum Season1{
    //1.必须在枚举类的开头声明多个对象，对象之间用‘，’隔开
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");
    private final String seasonName;
    private final String Desc;//季节的描述
    //私有化类的构造器
    private Season1(String seasonName,String Desc){
        this.seasonName=seasonName;
        this.Desc = Desc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getDesc() {
        return Desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}