//Michał Drelich 41347

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Zadanie 1
        System.out.println("Zadanie 1");
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");

        System.out.println(zbiorDni);

        /*1. HashSet jest szybszy, za to TreeSet segreguje elementy zbioru w sposób rosnący
         * 2. W przypadku jeśli chcemy mieć posegregowane elementy zbioru to należy wykorzystać TreeSet
         * 3. Nie, należy tylko zmienić typ klasy zbioru*/

        System.out.println("\n");


        //Zadanie 2
        System.out.println("Zadanie 2");
        Map<String, Teacher> nauczyciele = new HashMap<>();
        Teacher t1 = new Teacher("Bjarne", "Stroustrup", "bjarne@fake.org", "Introduction to C++");
        Teacher t2 = new Teacher("Adam", "Kowalski", "kowal@fake.org", "Programowanie obiektowe");
        Teacher t3 = new Teacher("Krzysztof", "Małecki", "malecki@fake.org", "Seminarium dyplomowe");
        Teacher t4 = new Teacher("Zbigniew", "Pawlak", "pawlak@fake.org", "Wychowanie fizyczne");
        nauczyciele.put(t1.getCourseName(), t1);
        nauczyciele.put(t2.getCourseName(), t2);
        nauczyciele.put(t3.getCourseName(), t3);
        nauczyciele.put(t4.getCourseName(), t4);
        System.out.println(nauczyciele.get("Programowanie obiektowe"));

        List<Student> studenci31 = new ArrayList<>();
        List<Student> studenci32 = new ArrayList<>();
        List<Student> studenci33 = new ArrayList<>();
        List<Student> studenci34 = new ArrayList<>();

        Map<String, List<Student>> studenci = new HashMap<>();

        Student s1 = new Student("Jan", "Kowalski", "jkowalski@wi.zut.edu.pl", "31");
        Student s2 = new Student("Hermenegilda", "Nowak", "henowak@wi.zut.edu.pl", "32");
        Student s3 = new Student("Kacper", "Kowalik", "kkowalki@wi.zut.edu.pl", "32");
        Student s4 = new Student("Konrad", "Lis", "klis@wi.zut.edu.pl", "33");
        Student s5 = new Student("Adam", "Królik", "akrolik@wi.zut.edu.pl", "34");
        studenci31.add(s1); studenci32.add(s2); studenci32.add(s3); studenci33.add(s4); studenci34.add(s5);

        studenci.put("31", studenci31);
        studenci.put("32", studenci32);
        studenci.put("33", studenci33);
        studenci.put("34", studenci34);

        System.out.println(studenci.get("32"));
        System.out.println("\n");

        //Zadanie 3
        System.out.println("Zadanie 3");
        List<Product> produkty = new ArrayList<>();

        Map<Integer, Product> produkty_po_ID = new HashMap<>();
        Map<String, List<Product>> produkty_po_cat = new HashMap<>();
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String lane = in.readLine();

            while(lane!=null) {
                String[] split_lane = lane.split(";");
                int ID = Integer.parseInt(split_lane[0]);
                double price = Double.parseDouble(split_lane[3]);
                Product nowy_produkt = new Product(ID, split_lane[1], price, split_lane[2]);

                produkty.add(nowy_produkt);
                produkty_po_ID.put(ID, nowy_produkt);

                if(produkty_po_cat.containsKey(split_lane[2])) {
                    List<Product> nowy_cat = produkty_po_cat.get(split_lane[2]);
                    nowy_cat.add(nowy_produkt);
                    produkty_po_cat.replace(split_lane[2], nowy_cat);
                }
                else {
                    List<Product> nowa_lista = new ArrayList<>();
                    nowa_lista.add(nowy_produkt);
                    produkty_po_cat.put(split_lane[2], nowa_lista);
                }

                lane = in.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(produkty_po_cat.get("elektronika"));
        System.out.println(produkty_po_ID.get(105));
    }
}
