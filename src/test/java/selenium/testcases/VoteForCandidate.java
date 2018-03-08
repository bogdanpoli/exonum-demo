package selenium.testcases;

import selenium.SeleniumTestWrapper;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.pageobjects.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class VoteForCandidate extends SeleniumTestWrapper {

    StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
    ElectionsPage electionsPage = PageFactory.initElements(getDriver(), ElectionsPage.class);
    ElectionsCandidatesPage electionsCandidatesPage = PageFactory.initElements(getDriver(), ElectionsCandidatesPage.class);
    BallotReceiptPage ballotReceiptPage = PageFactory.initElements(getDriver(), BallotReceiptPage.class);
    SignedBallotPage signedBallotPage = PageFactory.initElements(getDriver(), SignedBallotPage.class);
    EmailSteps emailSteps = PageFactory.initElements(getDriver(), EmailSteps.class);

    @Before
    public void setup() {
        startPage.open();
    }

    @Test
    public void cancelVoteSubmission() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndCanceled();
    }

    @Test
    public void discardVote() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.discardVote();
        homePage.homePageIsOpened();
    }

    @Test
    public void decryptVote() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.decryptVote();
        //TODO check memo
    }

    @Test
    public void cancelDecryptVote() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.cancelDecryptVote();
    }

    @Test
    public void submitSignedVote() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.signVote();
        ballotReceiptPage.enterPin();
        signedBallotPage.submitBallot();
        //TODO assert memo and hash
    }

    @Test
    public void receiveEmailBallotConfirmation() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.signVote();
        ballotReceiptPage.enterPin();
        signedBallotPage.provideEmailAddress();
        signedBallotPage.submitBallot();
        emailSteps.checkMail();
    }

    @Test
    public void DiscardSignedVote() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.signVote();
        ballotReceiptPage.enterPin();
        signedBallotPage.discardBallot();
        homePage.homePageIsOpened();
    }

    @Test
    public void SaveMemoAndHash() {
        homePage.pressVote();
        electionsPage.selectUsElection();
        electionsCandidatesPage.candidateIsSelectedAndSubmitted();
        ballotReceiptPage.saveMemoAndHash();
    }
}

