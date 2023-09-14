package ua.com.danit;

@MyAnno
@Deprecated
public class MyAnnoEx {
    public static void main(String[] args) {
        MyAnno annotation = MyAnnoEx.class.getAnnotation(MyAnno.class);
        if (annotation != null) {
            System.out.println("Annotation is  present");
        }
    }
}
