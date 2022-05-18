package entities.items;

public class LottoTicket extends Item {
    public LottoTicket() {
        super();
    }

    public int lottoTicketChanceIncreasePercentage;

    public void setLottoTicketChanceIncreasePercentage(int inputLottoTicketChanceIncreasePercentage) {
        this.lottoTicketChanceIncreasePercentage = inputLottoTicketChanceIncreasePercentage;
    }

    public int getLottoTicketChanceIncreasePercentage() {
        return this.lottoTicketChanceIncreasePercentage;
    }
}
