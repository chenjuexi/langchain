package com.hkh.ai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.hkh.ai.chain.llm.ChatService;
import com.hkh.ai.chain.llm.ChatServiceFactory;
import com.hkh.ai.domain.SysUser;
import com.hkh.ai.domain.function.LocationWeather;
import com.hkh.ai.request.*;
import com.hkh.ai.service.CompletionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CompletionServiceImpl implements CompletionService {

    private final ChatServiceFactory chatServiceFactory;

    @Override
    public String summary(SysUser sysUser, CompletionSummaryRequest request) {
        String fullContent = "请将文本内容生成对应摘要： " + request.getContent() + "\n\n";
        if (StrUtil.isNotBlank(request.getPrompt())){
            fullContent += "具体要求如下：" + request.getPrompt();
        }
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.blockCompletion(fullContent);
        return completionResult;
    }

    @Override
    public String keyword(SysUser sysUser, CompletionKeywordRequest request) {
        String fullContent = "从下面文本中提取" +request.getKeywordNum() +"个"+request.getKeywordArea()+"领域关键词： " + request.getContent() + "\n\n每个关键词以英文分号;分隔";
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.blockCompletion(fullContent);
        return completionResult;
    }

    @Override
    public String translate(SysUser sysUser, CompletionTranslateRequest request) {
        String fullContent = "将下面文本翻译成" +request.getTargetLanguage() + ":" + request.getContent() ;
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.blockCompletion(fullContent);
        return completionResult;
    }

    @Override
    public String classic(SysUser sysUser, CompletionClassicRequest request) {
        String fullContent = "按照括号里的分类(" + request.getCategoryList() +" )，将以下文本进行分类：" +request.getContent() +  "\n\n依据相关性高低返回2~3个分类结果，并以;进行分隔";
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.blockCompletion(fullContent);
        return completionResult;
    }

    @Override
    public String security(SysUser sysUser, CompletionSecurityRequest request) {
        String fullContent = "判断以下文本是否包含政治、暴力、色情、毒品、恐怖、歧视等敏感内容：" + request.getContent() +  "\n\n，你只能回答2个字：安全或者危险";
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.blockCompletion(fullContent);
        return completionResult;
    }

    @Override
    public String function(SysUser sysUser, String content, String functionName, String description, Class clazz) {
        ChatService chatService = chatServiceFactory.getChatService();
        String completionResult = chatService.functionCompletion(content, functionName, description,clazz);
        return completionResult;
    }

    @Override
    public String functionWeather(SysUser sysUser, CompletionFunctionWeatherRequest request) {
        String completionResult = function(sysUser,request.getContent(), "get_location_weather", "the current weather of a location ", LocationWeather.class);
        return completionResult;
    }

}
