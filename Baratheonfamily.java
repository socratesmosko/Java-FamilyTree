
package baratheonfamily;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baratheonfamily {
    public static void main(String[] args) throws IOException  {
        int b;
        do{
            b = dashboard();
            if(b == 1)
                csvRead();
            if(b == 2)
                relationGet();
            if(b == 3)
                alphabeticalorder();
            if(b == 4)
                membersList();
            if(b==5)
                getCSVtoArray("C:\\Users\\giann\\Desktop\\baratheonfamilytree.csv").forEach(data -> System.out.println(Arrays.toString(data)));

        }while(b != 6);
    }
    //Αυτό είναι το dashboard το οποίο σας δίνει τις επιλογες για το προγραμμα.
    public static int dashboard(){
        System.out.println("DashBoard for Baratheon Family");
        System.out.println("-------------------------");
        System.out.println("1. Read File");
        System.out.println("2. Show Relation ");
        System.out.println("3. AlphabeticalOrder of Baratheon Family");
        System.out.println("4. Family Members");
        System.out.println("5. Read File and Store it into a ArrayList");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Choose 1-6: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }
    public static void relationGet(){
        String name1;
        String name2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        name1 = scanner.nextLine();
        System.out.println("Enter second name:");
        name2 = scanner.nextLine();
        System.out.println(getRelation(name1,name2));
    }
    //Αυτή η μέθοδος 
 public static String getRelation(String name1,String name2){
     for(String[] relation :relations){
         if(relation[0].equalsIgnoreCase(name1)&&relation[1].equalsIgnoreCase(name2)){
             return relation[2];
         }
 }
        return null;
    
} 
public static void csvRead(){
        String filecsv="C:\\Users\\giann\\Desktop\\baratheonfamilytree.csv";//Αλλαξτετο οταν ειναι να δείτε το πρόγραμμα
        String l=" ";
        String Split=",";

        try(BufferedReader breader= new BufferedReader(new FileReader(filecsv))){
            while ((l=breader.readLine())!=null){
                String[] allString=l.split(Split);
                System.out.println(allString[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<String[]> getCSVtoArray(String filename) {
        List<String[]> d = new ArrayList<>();
        String tRow;
        try {
            BufferedReader breader = new BufferedReader(new FileReader(filename));
            // Διαβάστε δεδομένα αρκεί να μην είναι άδεια
            // Αναλύστε τα δεδομένα με κόμμα χρησιμοποιώντας τη μέθοδο .split().
            // Τοποθετήστε σε έναν προσωρινό πίνακα και, στη συνέχεια, προσθέστε το στη λίστα
            while ((tRow = breader.readLine()) != null) {
                String[] li = tRow.split(",");
                d.add(li);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found " + filename);
        } catch (IOException e) {
            System.out.println("ERROR: Could not read " + filename);
        }

        return d;

    }
//Αυτή εδώ η μέθοδος μας εμφανίζει την οικογένεια baratheon σε LinkedList
  
    //Αυτή η μέθοδος βάζει σε λεξικογραφική σειρά τα ονόματα απο το BaratheonFamily
    public static void alphabeticalorder(){
        int n=13;
        String names[]={
                "STEFFON BARATHEON(MALE)","CASSANA ESTERMONT(FEMALE)","ROBERT BARATHEON(MALE)","CERSEI LANNISTER(FEMALE)",
            "STANNIS BARATHEON(MALE)","SELYSE BARATHEON(FEMALE)",
            "RENLY BARATHEON(MALE)","MARGAERY TYRELL(FEMALE)","GENDRY(MALE)",
            "JOFFREY BARATHEON(MALE)","MYRCELLA BARATHEON(FEMALE)","TOMMEN BARATHEON(MALE)","SHIREEN BARATHEON(FEMALE)"
        };
        String temporaryvar;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                //Εδώ συγκρίνουμε 2 strings μεταξύ τους
                if(names[i].compareTo(names[j]) > 0){
                    temporaryvar=names[i];
                    names[i]=names[j];
                    names[j]=temporaryvar;
                }
            }
        }
        System.out.println("Τα ονόματα σε λεξικογραφική σειρά: ");
        for(int i=0; i<n; i++){
            System.out.println(names[i]);
        }
        System.out.println("\n");
    }
    //Αυτή εδώ η μέθοδος διαβάζει το file με τα στοιχεία από το baratheon family
      public static void membersList(){
        System.out.println("Τα μέλη είναι τα εξής:");
        LinkedList<String> family=new LinkedList<>();
        family.add("Steffon Baratheon");
        family.add("Cassana Estermont");
        family.add("Robert Baratheon");
        family.add("Stannis Baratheon");
        family.add("Renly Baratheon");
        family.add("Cersei Lannister");
        family.add("Selyse Baratheon");
        family.add("Margaery Tyrell");
        family.add("Gendry");
        family.add("Joffrey Baratheon");
        family.add("Myrcella Baratheon");
        family.add("Tommen Baratheon");
        family.add("Shireen Baratheon");
        System.out.println(family);
        System.out.println("\n");
    }
//Ολα αυτά αρχικά γράφτηκαν σε notepad++ και μετά έγιναν copy paste εδώ απο το file.
    static String[][] relations = {
            //Robert
            {"Robert Baratheon", "Stannis Baratheon", "Αδέλφια"},
            {"Robert Baratheon", "Renly Baratheon", "Αδέλφια"},
            {"Robert Baratheon", "Gendry", "Πατέρας και Γιός"},
            {"Robert Baratheon", "Steffon Baratheon", "Γιός και Πατέρας"},
            {"Robert Baratheon", "Cassana Baratheon", "Γιός και μητέρα"},
            {"Robert Baratheon", "Cersei Lannister", "Ο Σύζυγος, η Σύζυγος"},
            {"Robert Baratheon", "Joffrey Baratheon", "Δεν σχετίζονται"},
            {"Robert Baratheon", "Myrcella Baratheon", "Δεν σχετίζονται"},
            {"Robert Baratheon", "Tommen Baratheon", "Δεν σχετίζονται"},
            {"Robert Baratheon", "Selyse Baratheon", "Δεν σχετίζονται"},
            {"Robert Baratheon", "Margaery Tyrell", "Δεν σχετίζονται"},
            {"Robert Baratheon", "Shireen Baratheon","Θείος και Ανιψιά"},
            //Gendry
            {"Gendry", "Robert Baratheon", "Γιός και Πατέρας"},
            {"Gendry", "Stannis Baratheon", "Ανιψίος και θείος"},
            {"Gendry", "Renly Baratheon", "Ανιψίος και θείος"},
            {"Gendry", "Steffon Baratheon", "Εγγονός και Παππούς"},
            {"Gendry", "Cassana Baratheon", "Εγγονός και Γιαγιά"},
            {"Gendry", "Cersei Lannister", "Δεν σχετίζονται"},
            {"Gendry", "Joffrey Baratheon", "Δεν σχετίζονται"},
            {"Gendry", "Myrcella Baratheon", "Δεν σχετίζονται"},
            {"Gendry", "Tommen Baratheon", "Δεν σχετίζονται"},
            {"Gendry", "Selyse Baratheon", "Ανιψιός και Θεία"},
            {"Gendry", "Margaery Tyrell","Ανιψιός και Θεία"},
            {"Gendry","Shireen Baratheon","Ξάδελφος και Ξαδέλφη"},
            //Cersei
            {"Cersei Lannister","Robert Baratheon","Η Σύγυζος και Ο Σύζυγος"},
            {"Cersei Lannister","Stannis Baratheon","Δεν σχετίζονται"},
            {"Cersei Lannister","Renly Baratheon","Δεν σχετίζονται"},
            {"Cersei Lannister","Steffon Baratheon","Δεν σχετίζονται"},
            {"Cersei Lannister","Cassana Baratheon","Δεν σχετίζονται"},
            {"Cersei Lannister","Joffrey Baratheon","Μητέρα και Γιός"},
            {"Cersei Lannister","Myrcella Baratheon","Μητέρα και Κόρη"},
            {"Cersei Lannister","Tommen Baratheon","Μητέρα και Γιός"},
            {"Cersei Lannister","Selyse Baratheon","Δεν σχετίζονται"},
            {"Cersei Lannister","Margaery Tyrell","Δεν σχετίζονται"},
            {"Cersei Lannister","Shireen Baratheon","Θεία και ανηψιά"},
            {"Cersei Lannister","Gendry","Δεν σχετίζονται"},
            //Joffrey
            {"Joffrey Baratheon","Robert Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Stannis Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Renly Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Steffon Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Cassana Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Myrcella Baratheon","Αδελφός και Αδελφή"},
            {"Joffrey Baratheon","Tommen Baratheon","Αδελφός και Αδελφός"},
            {"Joffrey Baratheon","Selyse Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Shireen Baratheon","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Gendry","Δεν σχετίζονται"},
            {"Joffrey Baratheon","Cersei Lannister","Μητέρα και Γιός"},
            //Tommen
            {"Tommen Baratheon","Robert Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Stannis Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Renly Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Steffon Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Cassana Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Myrcella Baratheon","Αδελφός και Αδελφή"},
            {"Tommen Baratheon","Joffrey Baratheon","Αδελφός και Αδελφός"},
            {"Tommen Baratheon","Selyse Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Tommen Baratheon","Shireen Baratheon","Δεν σχετίζονται"},
            {"Tommen Baratheon","Gendry","Δεν σχετίζονται"},
            {"Tommen Baratheon","Cersei Lannister","Μητέρα και Γιός"},
            //Myrcella
            {"Myrcella Baratheon", "Robert Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Stannis Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Renly Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Steffon Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Cassana Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Joffrey Baratheon","Αδελφός και Αδελφή"},
            {"Myrcella Baratheon", "Tommen Baratheon","Αδελφός και Αδελφός"},
            {"Myrcella Baratheon", "Selyse Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Margaery Tyrell","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Shireen Baratheon","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Gendry","Δεν σχετίζονται"},
            {"Myrcella Baratheon", "Cersei Lannister","Μητέρα και Κόρη"},
            //Steffon
            {"Steffon Baratheon","Robert Baratheon","Πατέρας και Γιός"},
            {"Steffon Baratheon","Stannis Baratheon","Πατέρας και Γιός"},
            {"Steffon Baratheon","Renly Baratheon","Πατέρας και Γιός"},
            {"Steffon Baratheon","Cassana Baratheon","Ο Σύζυγος και η Σύζυγος"},
            {"Steffon Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Steffon Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Steffon Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Steffon Baratheon","Selyse Baratheon","Δεν σχετίζονται"},
            {"Steffon Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Steffon Baratheon","Shireen Baratheon","Ο Παππούς και η Εγγονή"},
            {"Steffon Baratheon","Gendry","Ο Παππούς και ο Εγγονός"},
            {"Steffon Baratheon","Cersei Lannister","Δεν σχετίζονται"},
            //Cassana
            {"Cassana Baratheon","Robert Baratheon","Η Μητέρα και ο Γιός"},
            {"Cassana Baratheon","Stannis Baratheon","Η Μητέρα και ο Γιός"},
            {"Cassana Baratheon","Renly Baratheon","Η Μητέρα και ο Γιός"},
            {"Cassana Baratheon","Steffon Baratheon","Ο Σύζυγος και η Σύζυγος"},
            {"Cassana Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Cassana Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Cassana Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Cassana Baratheon","Selyse Baratheon","Δεν σχετίζονται"},
            {"Cassana Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Cassana Baratheon","Shireen Baratheon","Η Γιαγιά και η Εγγονή"},
            {"Cassana Baratheon","Gendry","Η Γιαγιά και ο Εγγονός"},
            {"Cassana Baratheon","Cersei Lannister","Δεν σχετίζονται"},
            //Selyse
            {"Selyse Baratheon","Robert Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Stannis Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Renly Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Steffon Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Cassana Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Selyse Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Selyse Baratheon","Shireen Baratheon","Η Μητέρα και η κόρη"},
            {"Selyse Baratheon","Gendry","Η θεία και ο ανιψιός"},
            {"Selyse Baratheon","Cersei Lannister","Δεν σχετίζονται"},
            //Margaery
            {"Margaery Tyrell","Robert Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Stannis Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Renly Baratheon","Ο σύζυγος και η σύζυγος"},
            {"Margaery Tyrell","Steffon Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Cassana Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Tommen Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Selyse Baratheon","Δεν σχετίζονται"},
            {"Margaery Tyrell","Shireen Baratheon"," Η θεία και η ανηψιά"},
            {"Margaery Tyrell","Gendry","Θεία και ανηψιός"},
            {"Margaery Tyrell","Cersei Lannister","Δεν σχετίζονται"},
            //Shireen
            {"Shireen Baratheon","Robert Baratheon","Η ανηψιά και ο θείος"},
            {"Shireen Baratheon","Stannis Baratheon","Ο πατέτας και η κόρη"},
            {"Shireen Baratheon","Renly Baratheon","Η ανηψιά και ο θείος"},
            {"Shireen Baratheon","Steffon Baratheon","Η εγγονή και Ο παππούς "},
            {"Shireen Baratheon","Cassana Baratheon","η Εγγονή Η και  Γιαγιά "},
            {"Shireen Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Shireen Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Shireen Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Shireen Baratheon","Selyse Baratheon","Η Μητέρα και η κόρη"},
            {"Shireen Baratheon","Margaery Tyrell","Η ανηψιά και η θεία"},
            {"Shireen Baratheon","Gendry","O Ξάδελφος και η Ξαδέλφη"},
            {"Shireen Baratheon","Cersei Lannister","Δεν σχετίζονται"},
            //Stannis
            {"Stannis Baratheon","Robert Baratheon","Αδέλφια"},
            {"Stannis Baratheon","Renly Baratheon","Αδέλφια"},
            {"Stannis Baratheon","Steffon Baratheon","Γιός και Πατέρας"},
            {"Stannis Baratheon","Cassana Baratheon","Γιός και Μητέρα"},
            {"Stannis Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Stannis Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Stannis Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Stannis Baratheon","Selyse Baratheon","Ο Σύζυγος και η Σύζυγος"},
            {"Stannis Baratheon","Margaery Tyrell","Δεν σχετίζονται"},
            {"Stannis Baratheon","Shireen Baratheon","Ο πατέρας και η κόρη"},
            {"Stannis Baratheon","Gendry","Ο θείος και ο ανιψιός"},
            {"Stannis Baratheon","Cersei Lannister","Δεν σχετίζονται"},
            //Renly
            {"Renly Baratheon","Robert Baratheon","Αδέλφια"},
            {"Renly Baratheon","Stannis Baratheon","Αδέλφια"},
            {"Renly Baratheon","Steffon Baratheon","Γιός και Πατέρας"},
            {"Renly Baratheon","Cassana Baratheon","Γιός και Μητέρα"},
            {"Renly Baratheon","Myrcella Baratheon","Δεν σχετίζονται"},
            {"Renly Baratheon","Joffrey Baratheon","Δεν σχετίζονται"},
            {"Renly Baratheon","Tommen Baratheon","Δεν σχετίζονται"},
            {"Renly Baratheon","Selyse Baratheon","Δεν σχετίζονται"},
            {"Renly Baratheon","Margaery Tyrell","Ο σύζυγος και η σύζυγος"},
            {"Renly Baratheon","Shireen Baratheon","Ο θείος και η ανιψιά"},
            {"Renly Baratheon","Gendry","Ο θείος και ο ανιψιός"},
            {"Renly Baratheon","Cersei Lannister","Δεν σχετίζονται"},
    };
}