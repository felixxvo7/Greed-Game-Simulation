public class MenuItem implements Selectable {
    private String description;
    private Runnable action;

    public MenuItem(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    @Override
    public boolean select(Viewable v, GameLogical gl) {
        action.run();
        return true;
    }

    public String getDescription() {
        return description;
    }
}
