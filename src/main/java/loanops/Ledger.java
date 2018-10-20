package loanops;

import domain.Assignment;
import domain.Yield;
import utils.Constants;
import utils.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Ledger {
    static final String assignmentsFilename = Environment.getPath() + File.separator + "assignments.csv";
    static final String yieldsFilename = Environment.getPath() + File.separator + "yields.csv";

    private FundingManager fundingManager;

    public Ledger(FundingManager fundingManager) {
        this.fundingManager = fundingManager;
    }

    public FundingManager getFundingManager() {
        return fundingManager;
    }

    public void setFundingManager(FundingManager fundingManager) {
        this.fundingManager = fundingManager;
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "fundingManager=" + fundingManager +
                '}';
    }

    public void writeOutAssignments() {
        List<Assignment> assignmentList = fundingManager.getAssignmentList();
        if(assignmentList != null) {

            try (FileWriter fileWriter = new FileWriter(assignmentsFilename);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.print(Constants.LOAN_ID);
                printWriter.print(Constants.DELIMETER);
                printWriter.print(Constants.FACILITY_ID);
                assignmentList.forEach(assignment -> printWriter.println(assignment.asDelimetedString()));
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeOutYields() {
        List<Yield> yieldList = fundingManager.getYieldList();

        if(yieldList != null) {
            try (FileWriter fileWriter = new FileWriter(assignmentsFilename);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.print(Constants.LOAN_ID);
                printWriter.print(Constants.DELIMETER);
                printWriter.print(Constants.FACILITY_ID);
                yieldList.forEach(yield -> printWriter.println(yield.asDelimetedString()));
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
