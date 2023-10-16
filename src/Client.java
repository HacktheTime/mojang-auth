import java.math.BigInteger;
import java.util.Random;

public class Client {
    //Those are for those versions tested.
    // I believe since its mojangs minecraft libraries its independent of what modding framework but don't quote me on that
    //1.8.9 (forge). minecraft is not imported as library so that why its red. i used it in a mod of mine
    public void mojangAuthOld(String serverId){
        try {
            Minecraft.getMinecraft().getSessionService().joinServer(
                    Minecraft.getMinecraft().getSession().getProfile(),
                    Minecraft.getMinecraft().getSession().getToken(),
                    serverId);
        } catch (AuthenticationException e) {
//TODO            Do exeption code here (you)
        }
    }

    //1.20.2 fabric
    public void mojangAuthNew(String serverId) {
        try {
            MinecraftClient.getInstance().getSessionService().joinServer(
                    MinecraftClient.getInstance().getGameProfile().getId(),
                    MinecraftClient.getInstance().getSession().getAccessToken(),
                    serverId);
        } catch (AuthenticationException ignored) {
//TODO            Do exeption code here (you)
        }
    }

    public String randomStringGenerator(){
        // Source for this: https://github.com/NotEnoughUpdates/NotEnoughUpdates/blob/master/src/main/java/io/github/moulberry/notenoughupdates/cosmetics/GuiCosmetics.java
        // Read the readme for more info about security.
        Random r1 = new Random();
        Random r2 = new Random(System.identityHashCode(new Object()));
        BigInteger random1Bi = new BigInteger(128, r1);
        BigInteger random2Bi = new BigInteger(128, r2);
        BigInteger serverBi = random1Bi.xor(random2Bi);
        String serverId = serverBi.toString(16);
        return serverId;
    }
}
