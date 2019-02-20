package untestableLegacy;

public class EntityFactory {

    FormatNameService formatNameService;

    public EntityFactory(FormatNameService formatNameService) {
        this.formatNameService = formatNameService;
    }

    public Entity createEntity(String name){
        String formatName = formatNameService.removeIllegalChars(name);
        Entity entity = new Entity();
        entity.setName(formatName);
        return entity;
    }
}
