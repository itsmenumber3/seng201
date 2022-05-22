package entities.items;

public class LottoTicket extends Item {
    public LottoTicket() {
        super();
    }

    private int lottoTicketNumber;

    public boolean setLottoTicketNumber(int inputTicketNumber) {
        if (inputTicketNumber <= 5 && inputTicketNumber >= 1) {
            lottoTicketNumber = inputTicketNumber;
            return true;
        } else {
            return false;
        }
    }

    public int getLottoTicketNumber() {
        return lottoTicketNumber;
    }
}
