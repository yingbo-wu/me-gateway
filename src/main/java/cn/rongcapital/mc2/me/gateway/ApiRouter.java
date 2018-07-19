package cn.rongcapital.mc2.me.gateway;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteServiceFactory;
import cn.rongcapital.mc2.me.cpm.api.CampaignApi;
import cn.rongcapital.mc2.me.cpm.api.CampaignDiagramApi;
import cn.rongcapital.mc2.me.cpm.api.CampaignFlowApi;
import cn.rongcapital.mc2.me.cpm.api.ComponentApi;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignCreateForCdpIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignCreateIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignDeleteIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignDiagramSaveIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFindOneIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFindOneOut;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFlowPublishIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFlowShutdownIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignNameCheckIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignPagingIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignPagingOut;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignUpdateIn;
import cn.rongcapital.mc2.me.cpm.api.dto.ComponentFindIn;
import cn.rongcapital.mc2.me.cpm.api.dto.ComponentFindOut;
import cn.rongcapital.mc2.me.ewa.api.CampaignStatApi;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindOut;
import reactor.core.publisher.Mono;

@RestController
public class ApiRouter {

	@PostMapping(path = "/api/campaign/check-name", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<Boolean>> campaignNameCheck(@Validated @RequestBody CampaignNameCheckIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<Boolean> result = campaignApi.checkName(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/create", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<String>> campaignCreate(@Validated @RequestBody CampaignCreateIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.create(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/create-for-cdp", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<String>> campaignCreateForCdp(@Validated @RequestBody CampaignCreateForCdpIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.create(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/update", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<String>> campaignUpdate(@Validated @RequestBody CampaignUpdateIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.update(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/delete", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<Void>> campaignDel(@Validated @RequestBody CampaignDeleteIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<Void> result = campaignApi.delete(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/find-one", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<CampaignFindOneOut>> campaignFindOne(@Validated @RequestBody CampaignFindOneIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<CampaignFindOneOut> result = campaignApi.findOne(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/paging", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<CampaignPagingOut>> campaignPaging(@Validated @RequestBody CampaignPagingIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<CampaignPagingOut> result = campaignApi.paging(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/diagram/save", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<Void>> campaignDiagramSave(@Validated @RequestBody CampaignDiagramSaveIn in) {
		CampaignDiagramApi campaignDiagramApi = IgniteServiceFactory.newService(CampaignDiagramApi.class);
		ApiResult<Void> result = campaignDiagramApi.save(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/flow/publish", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<Void>> campaignFlowPublish(@Validated @RequestBody CampaignFlowPublishIn in) {
		CampaignFlowApi campaignFlowApi = IgniteServiceFactory.newService(CampaignFlowApi.class);
		ApiResult<Void> result = campaignFlowApi.publish(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/flow/shutdown", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<Void>> campaignFlowShutdown(@Validated @RequestBody CampaignFlowShutdownIn in) {
		CampaignFlowApi campaignFlowApi = IgniteServiceFactory.newService(CampaignFlowApi.class);
		ApiResult<Void> result = campaignFlowApi.shutdown(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/component/find", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<List<ComponentFindOut>>> componentFind(@Validated @RequestBody ComponentFindIn in) {
		ComponentApi componentApi = IgniteServiceFactory.newService(ComponentApi.class);
		ApiResult<List<ComponentFindOut>> result = componentApi.find(in);
		return Mono.just(result);
	}

	@PostMapping(path = "/api/campaign/stat/find", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Mono<ApiResult<List<CampaignStatFindOut>>> campaignStatFind(@Validated @RequestBody CampaignStatFindIn in) {
		CampaignStatApi campaignStatApi = IgniteServiceFactory.newService(CampaignStatApi.class);
		ApiResult<List<CampaignStatFindOut>> result = campaignStatApi.find(in);
		return Mono.just(result);
	}

}
