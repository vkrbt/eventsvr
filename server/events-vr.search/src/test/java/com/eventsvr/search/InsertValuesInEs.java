package com.eventsvr.search;

import com.eventsvr.search.repository.StreamRepository;
import com.eventsvr.search.stream.Stream;
import com.eventsvr.search.stream.StreamType;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class InsertValuesInEs  {
    private StreamRepository streamRepository;

    @Test
    public void insertValues() throws Exception {
        List<String> names = new ArrayList<String>() {{
            add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            add("Ut elementum felis sit amet diam aliquet sollicitudin.");
            add("Etiam quis nisi ac ante cursus bibendum ut quis tellus.");
            add("Morbi tincidunt diam eget nibh euismod, non aliquet lacus tempor.");
            add("Ut ultrices ligula scelerisque tellus porttitor interdum.");
            add("Etiam sed leo ac eros posuere hendrerit non eu nisl.");
            add("Pellentesque in tellus dictum, sollicitudin nisi et, luctus lectus.");
            add("Sed laoreet nulla eget ante sodales fringilla nec id neque.");
            add("Donec accumsan velit vitae ipsum imperdiet, sit amet condimentum sem dignissim.");
            add("Mauris pulvinar mauris eget gravida cursus.");
            add("Sed vitae lorem convallis, consequat augue in, eleifend odio.");
            add("Donec venenatis sapien nec nibh tempus gravida.");
            add("Donec vehicula mi eu viverra ultricies.");
            add("Nam vitae lorem eu purus imperdiet dapibus tempor non lacus.");
            add("Nam porttitor nisl in sapien consectetur, bibendum accumsan dui imperdiet.");
            add("Vivamus malesuada purus at neque imperdiet vestibulum.");
            add("Quisque lacinia lectus id neque malesuada tempus.");
            add("Nam hendrerit est a dui accumsan tempor.");
        }};

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            Stream stream = new Stream();
            stream.setName(names.get(random.nextInt(names.size())));
            stream.setStreamer(UUID.randomUUID().toString());
            stream.setViewersCount((long) (random.nextDouble() * 10000L));

            if (random.nextBoolean()) {
                stream.setStreamType(StreamType.FOOTBALL);
            } else {
                stream.setStreamType(StreamType.BASKETBALL);
            }

            stream.setThumbnail("http://weknowyourdreams.com/images/picture/picture-12.jpg");

            streamRepository.save(stream);
        }
    }

    @Autowired
    public void setStreamRepository(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }
}
