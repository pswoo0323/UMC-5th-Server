package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.base.Code;
import study.base.ResponseDto;
import study.converter.TempConverter;
import study.service.TempService.TempCommandService;
import study.service.TempService.TempQueryService;
import study.web.dto.TempRequest;
import study.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testAPI(){

        return ResponseDto.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
    }

    @GetMapping("/exception")
    public ResponseDto<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseDto.onSuccess(TempConverter.toTempExceptionDTO(flag), Code.OK);
    }
}