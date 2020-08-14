package com.spring.book.springboot.web;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile_조회() {
        //given
        String expectedProfile = "real";
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.addActiveProfile(expectedProfile);
        mockEnvironment.addActiveProfile("oauth");
        mockEnvironment.addActiveProfile("real-db");

        ProfileController profileController = new ProfileController(mockEnvironment);

        //when
        String profile = profileController.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile_없으면_첫번째_조회() {
        //given
        String expectedProfile = "oauth";
        MockEnvironment mockEnvironment = new MockEnvironment();

        mockEnvironment.addActiveProfile(expectedProfile);
        mockEnvironment.addActiveProfile("real-db");

        ProfileController profileController = new ProfileController(mockEnvironment);

        //when
        String profile = profileController.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile_없으면_default_조회() {
        //given
        String expectedProfile = "default";
        MockEnvironment mockEnvironment = new MockEnvironment();
        ProfileController profileController = new ProfileController(mockEnvironment);

        //when
        String profile = profileController.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }
}
