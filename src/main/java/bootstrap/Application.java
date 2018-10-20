package bootstrap;


import builder.Builder;
import domain.Bank;
import domain.Covenant;
import domain.Facility;
import domain.Loan;
import loanops.FundingManager;
import loanops.Ledger;
import utils.Environment;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        System.out.println("Starting app");
        //Initialize Banks, Facilities and their covenants
        System.out.println("Initializing banks");
        Environment.setPath(System.getProperty("myPath"));
        Map<Integer, Bank> banks = Builder.constructBanks();
        System.out.println("Initializing facilities");
        Map<Integer, Facility> facilities = Builder.constructFacilities();
        System.out.println("Initializing covenants");
        Map<Integer, Covenant> covenants = Builder.constructCovenants();
        System.out.println("Initializing loans");
        List<Loan> loans = Builder.getLoans();

        FundingManager fundingManager = new FundingManager(banks, facilities, covenants);
        if (loans == null) throw new AssertionError();
        loans.forEach(fundingManager::fundLoan);
        Ledger ledger = new Ledger(fundingManager);
        ledger.writeOutAssignments();
        ledger.writeOutYields();

    }

}
