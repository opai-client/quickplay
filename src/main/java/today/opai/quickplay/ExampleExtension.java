package today.opai.quickplay;

import today.opai.api.Extension;
import today.opai.api.OpenAPI;
import today.opai.api.annotations.ExtensionInfo;
import today.opai.api.events.EventChatSend;
import today.opai.api.interfaces.EventHandler;

// Required @ExtensionInfo annotation
@ExtensionInfo(name = "Quick Play",author = "cubk",version = "1.0")
public class ExampleExtension extends Extension {
    public static OpenAPI openAPI;

    @Override
    public void initialize(OpenAPI openAPI) {
        ExampleExtension.openAPI = openAPI;
        openAPI.registerEvent(new EventHandler() {
            @Override
            public void onChat(EventChatSend event) {
                if(event.getMessage().equals("/1s") || event.getMessage().equals("/2s") || event.getMessage().equals("/3s") || event.getMessage().equals("/4s")){
                    if(event.getMessage().equals("/1s")){
                        openAPI.getLocalPlayer().sendChatMessage("/play bedwars_eight_one");
                    }
                    if(event.getMessage().equals("/2s")){
                        openAPI.getLocalPlayer().sendChatMessage("/play bedwars_eight_two");
                    }
                    if(event.getMessage().equals("/3s")){
                        openAPI.getLocalPlayer().sendChatMessage("/play bedwars_four_three");
                    }
                    if(event.getMessage().equals("/4s")){
                        openAPI.getLocalPlayer().sendChatMessage("/play bedwars_four_four");
                    }
                    event.setCancelled(true);
                }
            }
        });
    }
}
