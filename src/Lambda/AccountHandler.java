package Lambda;

public interface AccountHandler {
    void onOpen();
    void onPut();
    void onWithdraw();
    void onError();
    void onClose();
}
