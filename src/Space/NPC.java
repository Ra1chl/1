package Space;

public class NPC {
    private String name;
    private String role;

    public NPC(String name, String role) {
        this.name = name;
        this.role = role;// Např. "obchodník", "pašerák", "nepřítel"
    }

    public void interact(Player player) {
        // Interakce hráče s NPC
    }
}
