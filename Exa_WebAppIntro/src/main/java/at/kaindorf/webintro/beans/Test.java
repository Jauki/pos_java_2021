package at.kaindorf.webintro.beans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        GuestbookEntry entry1 = new GuestbookEntry("james", "bond@d", "dsadisa");
        GuestbookEntry entry2 = new GuestbookEntry("dsa", "bonddasda@d", "dsadasdadisa");
        GuestbookEntry[] entries = {entry1, entry2};
        List<GuestbookEntry> entryList = Arrays.stream(entries)
                .collect(Collectors.toList());
        entryList.forEach(e -> System.out.println(e));
       // entryList.forEach(System.out::println); // Sollte mit parameter exakt von der Foreach +bereinstimmen
        GuestbookEntry[] entryArray = entryList.stream().toArray(GuestbookEntry[]::new);

        System.out.println("----");

        // Filter
        // 1:
        /*
        entryList = entryList.stream()
                .filter(guestbookEntry -> guestbookEntry.getEmail().contains("bond"))
                .collect(Collectors.toList()); // wird nicht gelöscht

         */
        // 2:
        //entryList.removeIf(guestbookEntry -> guestbookEntry.getEmail().contains("bond")); // wird weggeschmissn
        //entryList.removeIf(guestbookEntry -> {return guestbookEntry.getEmail().contains("bond");}); // macht es gleiche!


        // Sortieren

        entryList.stream()
                .sorted((e1, e2) -> e1.getNickname().compareTo(e2.getNickname()))
                .collect(Collectors.toList());

        entryList.sort(Comparator.comparing(GuestbookEntry::getNickname)
                .thenComparing(GuestbookEntry::getEmail)
                .reversed()); //Methoden referenz !! Man kann mehrere Comperatoren anschließen

        //entryList.sort(Comparator.naturalOrder());
        entryList.forEach(System.out::println);
    }
}
