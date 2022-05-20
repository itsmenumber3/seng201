package entities.items;

public class LottoTicket extends Item {
    public LottoTicket() {
        super();
    }

    public int lottoTicketNumber;

    public void setLottoTicketChanceIncreasePercentage(int inputLottoTicketChanceIncreasePercentage) {
        this.lottoTicketNumber = inputLottoTicketChanceIncreasePercentage;
    }

    public int getLottoTicketChanceIncreasePercentage() {
        return this.lottoTicketNumber;
    }
}
