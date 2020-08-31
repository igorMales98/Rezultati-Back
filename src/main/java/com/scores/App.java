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
import java.util.Random;
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

        System.out.println("Poceo je unos podataka o utakmicama bundeslige sezona 2020.");
        URL url7 = App.class.getResource("/data/season_1920_csv_germany.csv");
        File file7 = Paths.get(url7.toURI()).toFile();
        String bundes2020 = file7.getAbsolutePath();
        id = readFromCSVFile(bundes2020, id, 126L, 11L);

        System.out.println("Poceo je unos podataka o utakmicama bundeslige sezona 2019.");
        URL url8 = App.class.getResource("/data/season_1819_csv_germany.csv");
        File file8 = Paths.get(url8.toURI()).toFile();
        String bundes2019 = file8.getAbsolutePath();
        id = readFromCSVFile(bundes2019, id, 126L, 10L);

        System.out.println("Poceo je unos podataka o utakmicama bundeslige sezona 2018.");
        URL url9 = App.class.getResource("/data/season_1718_csv_germany.csv");
        File file9 = Paths.get(url9.toURI()).toFile();
        String bundes2018 = file9.getAbsolutePath();
        id = readFromCSVFile(bundes2018, id, 126L, 9L);

        System.out.println("Poceo je unos podataka o utakmicama ligue 1 sezona 2020.");
        URL url10 = App.class.getResource("/data/season_1920_csv_france.csv");
        File file10 = Paths.get(url10.toURI()).toFile();
        String ligue2020 = file10.getAbsolutePath();
        id = readFromCSVFile(ligue2020, id, 188L, 11L);

        System.out.println("Poceo je unos podataka o utakmicama ligue 1 sezona 2019.");
        URL url11 = App.class.getResource("/data/season_1819_csv_france.csv");
        File file11 = Paths.get(url11.toURI()).toFile();
        String ligue2019 = file11.getAbsolutePath();
        id = readFromCSVFile(ligue2019, id, 188L, 10L);

        System.out.println("Poceo je unos podataka o utakmicama ligue 1 sezona 2018.");
        URL url12 = App.class.getResource("/data/season_1718_csv_france.csv");
        File file12 = Paths.get(url12.toURI()).toFile();
        String ligue2018 = file12.getAbsolutePath();
        id = readFromCSVFile(ligue2018, id, 188L, 9L);

        System.out.println("Poceo je unos podataka o utakmicama serie a sezona 2020.");
        URL url13 = App.class.getResource("/data/season_1920_csv_italy.csv");
        File file13 = Paths.get(url13.toURI()).toFile();
        String seria2020 = file13.getAbsolutePath();
        id = readFromCSVFile(seria2020, id, 73L, 11L);

        System.out.println("Poceo je unos podataka o utakmicama serie a sezona 2019.");
        URL url14 = App.class.getResource("/data/season_1819_csv_italy.csv");
        File file14 = Paths.get(url14.toURI()).toFile();
        String seria2019 = file14.getAbsolutePath();
        id = readFromCSVFile(seria2019, id, 73L, 10L);

        System.out.println("Poceo je unos podataka o utakmicama serie a sezona 2018.");
        URL url15 = App.class.getResource("/data/season_1718_csv_italy.csv");
        File file15 = Paths.get(url15.toURI()).toFile();
        String seria2018 = file15.getAbsolutePath();
        id = readFromCSVFile(seria2018, id, 73L, 9L);

        System.out.println("KRAJ UNOSA_____________________________________________");


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
            Random random = new Random();
            int rand = random.nextInt(30) + 35;
            if (ligaId.equals(42L)) {
                insertInfoWithQuery(id, (float) rand, (float) 100 - rand, Integer.parseInt(rezultati.get(11)),
                        Integer.parseInt(rezultati.get(12)), Integer.parseInt(rezultati.get(19)), Integer.parseInt(rezultati.get(20)),
                        Integer.parseInt(rezultati.get(21)), Integer.parseInt(rezultati.get(22)));
            } else {
                insertInfoWithQuery(id, (float) rand, (float) 100 - rand, Integer.parseInt(rezultati.get(10)),
                        Integer.parseInt(rezultati.get(11)), Integer.parseInt(rezultati.get(18)), Integer.parseInt(rezultati.get(19)),
                        Integer.parseInt(rezultati.get(20)), Integer.parseInt(rezultati.get(21)));
            }
            id++;
        }
        return id;
    }

    public void insertInfoWithQuery(Long id, Float posedDomacin, Float posedGost, Integer suteviDomacin, Integer suteviGost,
                                    Integer zutiDomacin, Integer zutiGost, Integer crveniDomacin, Integer crveniGost) {
        entityManager.createNativeQuery("INSERT INTO informacija (id, posed_domacin, posed_gost, sutevi_domacin, sutevi_gost, broj_zutih_kartona_domacin, broj_zutih_kartona_gost, broj_crvenih_kartona_domacin, broj_crvenih_kartona_gost, rezultat_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")
                .setParameter(1, id)
                .setParameter(2, posedDomacin)
                .setParameter(3, posedGost)
                .setParameter(4, suteviDomacin)
                .setParameter(5, suteviGost)
                .setParameter(6, zutiDomacin)
                .setParameter(7, zutiGost)
                .setParameter(8, crveniDomacin)
                .setParameter(9, crveniGost)
                .setParameter(10, id)
                .executeUpdate();
    }

    public void insertFRWithQuery(Long id, Short goloviDomacin, Short goloviGost, LocalDateTime vreme, Long domacinId,
                                  Long gostId, Long ligaId, Long sezonaId) {
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
