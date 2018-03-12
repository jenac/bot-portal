package com.jenac.bot.portal.service;

import com.jenac.bot.portal.web.rest.vm.bot.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

@Ignore
public class BotServiceIntTest {
    static final String botServiceHost = "http://localhost:8888/";
    BotService botService;
    @Before
    public void setup() {
        botService = new BotService();
        botService.setBotServiceHost(botServiceHost);
    }

    @Test
    public void testAllApi() {
        //get state
        StateVM stateVM = botService.getState();
        assert (stateVM != null);

        //find the test user
        ContactVM found = stateVM.getContacts().stream().filter(c-> c.getRemark().endsWith("test")).findFirst().get();
        assert (found != null);

        //send text
        SendTextVM sendTextVM = new SendTextVM();
        sendTextVM.setTo(found.getUsername());
        sendTextVM.setText("Hello, I am sending this message from spring unit test!");
        ResponseVM responseVm = botService.sendText(sendTextVM);
        assert (responseVm.getSuccess());

        //send emotion
        SendEmotionVM sendEmotionVM = new SendEmotionVM();
        sendEmotionVM.setTo(found.getUsername());
        sendEmotionVM.setMd5("00c801cdf69127550d93ca52c3f853ff");
        responseVm = botService.sendEmotion(sendEmotionVM);
        assert(responseVm.getSuccess());

        //send picture
        SendPictureVM sendPictureVM = new SendPictureVM();
        sendPictureVM.setTo(found.getUsername());
        sendPictureVM.setUrl("https://raw.githubusercontent.com/jenac/kb/master/linux.jpeg");
        sendPictureVM.setFilename("linux.jpeg");
        responseVm = botService.sendPicture(sendPictureVM);
        assert (responseVm.getSuccess());

        //send image file
        SendFileVM sendImage = new SendFileVM();
        sendImage.setTo(found.getUsername());
        sendImage.setPath("/home/lihe/projects/bot-portal/src/main/webapp/content/images/hipster.png");
        sendImage.setFilename("hipster.png");
        responseVm = botService.sendFile(sendImage);
        assert (responseVm.getSuccess());

        //send mp3

        //send video


    }
}
