package com.scores;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@Transactional
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws URISyntaxException {
        Long id = 1L;

        System.out.println("Poceo je unos podataka o utakmicama premier lige sezona 2020.");
        URL url = App.class.getResource("/data/season_1920_csv.csv");
        File file = Paths.get(url.toURI()).toFile();
        String premier2020 = file.getAbsolutePath();
        id = readFromCSVFile(premier2020, id, 42L, 11L);

        System.out.println("Poceo je unos podataka o utakmicama premier lige sezona 2019.");
        URL url2 = App.class.getResource("/data/season_1819_csv.csv");
        File file2 = Paths.get(url2.toURI()).toFile();
        String premier2019 = file2.getAbsolutePath();
        id = readFromCSVFile(premier2019, id, 42L, 10L);

        System.out.println("Poceo je unos podataka o utakmicama premier lige sezona 2018.");
        URL url3 = App.class.getResource("/data/season_1718_csv.csv");
        File file3 = Paths.get(url3.toURI()).toFile();
        String premier2018 = file3.getAbsolutePath();
        id = readFromCSVFile(premier2018, id, 42L, 9L);

        System.out.println("Poceo je unos podataka o utakmicama la lige sezona 2020.");
        URL url4 = App.class.getResource("/data/season_1920_csv_spain.csv");
        File file4 = Paths.get(url4.toURI()).toFile();
        String laliga2020 = file4.getAbsolutePath();
        id = readFromCSVFile(laliga2020, id, 163L, 11L);

        System.out.println("Poceo je unos podataka o utakmicama la lige sezona 2019.");
        URL url5 = App.class.getResource("/data/season_1819_csv_spain.csv");
        File file5 = Paths.get(url5.toURI()).toFile();
        String laliga2019 = file5.getAbsolutePath();
        id = readFromCSVFile(laliga2019, id, 163L, 10L);

        System.out.println("Poceo je unos podataka o utakmicama la lige sezona 2018.");
        URL url6 = App.class.getResource("/data/season_1718_csv_spain.csv");
        File file6 = Paths.get(url6.toURI()).toFile();
        String laliga2018 = file6.getAbsolutePath();
        id = readFromCSVFile(laliga2018, id, 163L, 9L);


    }

    private Long readFromCSVFile(String absolutePath, Long id, Long ligaId, Long sezonaId) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(absolutePath));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("neam fajla");
            e.printStackTrace();
        }

        for (List<String> rezultati : records.subList(1, records.size())) {
            LocalDateTime datum = LocalDateTime.parse(rezultati.get(1) + " 21:00",
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            insertFRWithQuery(id, Short.parseShort(rezultati.get(4)), Short.parseShort(rezultati.get(5)), datum,
                    Long.parseLong(rezultati.get(2)), Long.parseLong(rezultati.get(3)), ligaId, sezonaId);
            id++;
        }
        return id;
    }

    public void insertFRWithQuery(Long id, Short goloviDomacin, Short goloviGost, LocalDateTime vreme, Long domacinId, Long gostId, Long ligaId, Long sezonaId) {
        entityManager.createNativeQuery("INSERT INTO fudbalski_rezultat (id, golovi_domacin, golovi_gost, vreme_odrzavanja_utakmice, domacin_id, gost_id, liga_id, sezona_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);")
                .setParameter(1, id)
                .setParameter(2, goloviDomacin)
                .setParameter(3, goloviGost)
                .setParameter(4, vreme)
                .setParameter(5, domacinId)
                .setParameter(6, gostId)
                .setParameter(7, ligaId)
                .setParameter(8, sezonaId)
                .executeUpdate();
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }


}
