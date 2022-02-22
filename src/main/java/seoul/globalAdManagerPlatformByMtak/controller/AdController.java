package seoul.globalAdManagerPlatformByMtak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seoul.globalAdManagerPlatformByMtak.dto.AdResponseDto;
import seoul.globalAdManagerPlatformByMtak.dto.AdUpdateRequestDto;
import seoul.globalAdManagerPlatformByMtak.dto.AdSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.service.AdService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdController {
    private final AdService adService;


    @GetMapping("/ad")
    public String save() {
        return "ad_form";

    }
    @CrossOrigin(origins = {"http://localhost:5500"})
    public Long save(
           @RequestParam("title") String title,
           @RequestParam("content") String content,
           @RequestParam("url") String url,
           @RequestParam("owner") String owner,
           @RequestParam("files") List<MultipartFile> files
    ) throws Exception {

        AdSaveRequestDto requestDto = AdSaveRequestDto.builder()
                .title(title)
                .content(content)
                .url(url)
                .adOwner(owner)
                .images(files)
                .build();
        return adService.adSave(requestDto);
    }

    @PutMapping("/ad/{id}")
    public Long update(@PathVariable Long id, @RequestBody AdUpdateRequestDto requestDto) {
        return adService.adUpdate(id, requestDto);
    }

    @GetMapping("/ad/{id}")
    public AdResponseDto findById(@PathVariable Long id) {
        return adService.findById(id);
    }
}
