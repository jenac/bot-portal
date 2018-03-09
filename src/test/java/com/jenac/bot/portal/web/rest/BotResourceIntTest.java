package com.jenac.bot.portal.web.rest;

import com.jenac.bot.portal.BotportalApp;
import com.jenac.bot.portal.service.BotService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the Bot REST controller.
 *
 * @see BotResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BotportalApp.class)
public class BotResourceIntTest {

    private MockMvc restMockMvc;

    @Autowired
    private BotService botService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        BotResource botResource = new BotResource(botService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(botResource)
            .build();
    }

    /**
     * Test state
     */
    @Test
    public void testState() throws Exception {
        restMockMvc.perform(get("/api/bot/state"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.loginUrl").value("http://www.google.com"))
            .andExpect(jsonPath("$.state").value("running"));
    }

// should we save error into mongo?
//        bot.on('error', err => {
//        console.error('错误：', err)
    /*
    //send text message:
    post: /bot/text
    body:
    {
        to: "someone",
        text: "hello, world"
    }
    response:
    {
        success: false
        message: "some error"
    }


    //send md5 emotion
    post: /bot/emotion/md5
    body: {
        to: "someone"
        md5: '00c801cdf69127550d93ca52c3f853ff'
    }
    response:
    {
        success: false
        message: "some error"
    }

    //send file
    // bot.sendMsg({
    //   file: Stream || Buffer || ArrayBuffer || File || Blob,
    //   filename: 'bot-qrcode.jpg'
    // }, ToUserName)
    //   .catch(err => {
    //     bot.emit('error',err)
    //   })

    //send picture
    post: /bot/picture
    body:
    {
        to: "sss"
        file: request('https://raw.githubusercontent.com/nodeWechat/wechat4u/master/bot-qrcode.jpg'),
        filename: 'bot-qrcode.jpg'
    }
    response:
    {
        success: false
        message: "some error"
    }

    //send gif emotion
    post: /bot/emotion/gif
    body:
    {
        to: "kkk",
        file: fs.createReadStream('./media/test.gif'),
        filename: 'test.gif'
    }
    response:
    {
        success: false
        message: "some error"
    }


    //send video
    post: /bot/video
    body:
    {
        to: "ok",
        file: fs.createReadStream('./media/test.mp4'),
        filename: 'test.mp4'
    }
    response:
    {
        success: false
        message: "some error"
    }

    //send file
    post: /bot/file
    body:
    {
        to: "aaa",
        file: fs.createReadStream('./media/test.txt'),
        filename: 'test.txt'
    }
    response:
    {
        success: false
        message: "some error"
    }


}
