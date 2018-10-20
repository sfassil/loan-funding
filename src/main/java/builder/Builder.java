package builder;

import domain.Bank;
import domain.Covenant;
import domain.Facility;
import domain.Loan;
import utils.Constants;
import utils.Environment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Builder {
    static final String bankFilename = Environment.getPath() + File.separator + "banks.csv";

    static final String covenantsFilename = Environment.getPath() + File.separator + "covenants.csv";
    static final String loansFilename = Environment.getPath() + File.separator + "loans.csv";
    static final String facilitiesFilename = Environment.getPath() + File.separator + "facilities.csv";

    public static Map<Integer, Covenant> constructCovenants() {

        Map<Integer, Covenant> covenantsMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(covenantsFilename)).skip(1)) {

            stream
                    .forEach(line -> {
                        String[] splitted = line.split(Constants.DELIMETER);
                        float maxDefault;
                        if(splitted[1].isEmpty())
                             maxDefault = Float.MAX_VALUE;
                        else
                             maxDefault = Float.valueOf(splitted[1]);
                        covenantsMap.putIfAbsent(Integer.valueOf(splitted[0]), new Covenant(Integer.valueOf(splitted[2]), Integer.valueOf(splitted[0]), maxDefault, splitted[3]));
                    });


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return covenantsMap;
    }

    public static Map<Integer, Facility> constructFacilities() {
        Map<Integer, Facility> facilityMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(facilitiesFilename)).skip(1)) {
        stream
                .forEach(line -> {
                    String[] splitted = line.split(Constants.DELIMETER);
                    facilityMap.putIfAbsent(Integer.valueOf(splitted[2]), new Facility(Integer.valueOf(splitted[3]), Integer.valueOf(splitted[2]), Float.valueOf(splitted[1]), Float.valueOf(splitted[0]).intValue()));
                });

    } catch (Exception e) {
        e.printStackTrace();
            return null;
    }
        return facilityMap;
    }

    public static Map<Integer, Bank> constructBanks() {
        Map<Integer, Bank> bankMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(bankFilename)).skip(1)) {

            stream
                    .forEach(line -> {
                        String[] splitted = line.split(Constants.DELIMETER);
                        bankMap.putIfAbsent(Integer.valueOf(splitted[0]), new Bank(Integer.valueOf(splitted[0]), splitted[1]));
                    });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bankMap;
    }

    public static List<Loan> getLoans(){
        List<Loan> loans = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(loansFilename)).skip(1)) {

            stream
                    .forEach(line -> {
                        String[] splitted = line.split(Constants.DELIMETER);
                        loans.add(new Loan(Integer.valueOf(splitted[2]), Integer.valueOf(splitted[1]), Float.valueOf(splitted[3]), Float.valueOf(splitted[0]), splitted[0]));
                    });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return loans;
    }
}
