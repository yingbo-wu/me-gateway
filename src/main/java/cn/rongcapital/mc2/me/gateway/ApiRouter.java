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
import cn.rongcapital.mc2.me.cpm.api.ComponentApi;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignCreateForCdpIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignCreateIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignDeleteIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignDiagramSaveIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFindOneIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignFindOneOut;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignNameCheckIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignPagingIn;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignPagingOut;
import cn.rongcapital.mc2.me.cpm.api.dto.CampaignUpdateIn;
import cn.rongcapital.mc2.me.cpm.api.dto.ComponentFindIn;
import cn.rongcapital.mc2.me.cpm.api.dto.ComponentFindOut;
import cn.rongcapital.mc2.me.ewp.api.CampaignFlowApi;
import cn.rongcapital.mc2.me.ewp.api.dto.CampaignFlowPublishIn;
import cn.rongcapital.mc2.me.ewp.api.dto.CampaignFlowShutdownIn;
import reactor.core.publisher.Flux;

@RestController
public class ApiRouter {

	@PostMapping(path = "/api/campaign/create", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<String>> campaignCreate(@Validated @RequestBody CampaignCreateIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.create(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/create-for-cdp", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<String>> campaignCreateForCdp(@Validated @RequestBody CampaignCreateForCdpIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.create(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/update", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<String>> campaignUpdate(@Validated @RequestBody CampaignUpdateIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<String> result = campaignApi.update(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/check-name", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<Boolean>> campaignNameCheck(@Validated @RequestBody CampaignNameCheckIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<Boolean> result = campaignApi.checkName(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/paging", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<CampaignPagingOut>> campaignPaging(@Validated @RequestBody CampaignPagingIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<CampaignPagingOut> result = campaignApi.paging(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/find-one", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<CampaignFindOneOut>> campaignFindOne(@Validated @RequestBody CampaignFindOneIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<CampaignFindOneOut> result = campaignApi.findOne(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/delete", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<Void>> campaignDel(@Validated @RequestBody CampaignDeleteIn in) {
		CampaignApi campaignApi = IgniteServiceFactory.newService(CampaignApi.class);
		ApiResult<Void> result = campaignApi.delete(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/component/find", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<List<ComponentFindOut>>> componentFind(@Validated @RequestBody ComponentFindIn in) {
		ComponentApi componentApi = IgniteServiceFactory.newService(ComponentApi.class);
		ApiResult<List<ComponentFindOut>> result = componentApi.find(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/diagram/save", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<Void>> campaignDiagramSave(@Validated @RequestBody CampaignDiagramSaveIn in) {
		CampaignDiagramApi campaignDiagramApi = IgniteServiceFactory.newService(CampaignDiagramApi.class);
		ApiResult<Void> result = campaignDiagramApi.save(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/flow/publish", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<Void>> campaignFlowPublish(@Validated @RequestBody CampaignFlowPublishIn in) {
		CampaignFlowApi campaignFlowApi = IgniteServiceFactory.newService(CampaignFlowApi.class);
		ApiResult<Void> result = campaignFlowApi.publish(in);
		return Flux.just(result);
	}

	@PostMapping(path = "/api/campaign/flow/shutdown", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public Flux<ApiResult<Void>> campaignFlowShutdown(@Validated @RequestBody CampaignFlowShutdownIn in) {
		CampaignFlowApi campaignFlowApi = IgniteServiceFactory.newService(CampaignFlowApi.class);
		ApiResult<Void> result = campaignFlowApi.shutdown(in);
		return Flux.just(result);
	}

	public Flux<ApiResult<List<?>>> campaignStatFind() {
		// TODO Auto-generated method stub
		return null;
	}

}
